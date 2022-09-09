package ca.bc.gov.educ.api.studentgraduation.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.bc.gov.educ.api.studentgraduation.model.dto.*;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.TranscriptMessageTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.TranscriptMessageRepository;
import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import ca.bc.gov.educ.api.studentgraduation.util.ThreadLocalStateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.transformer.LetterGradeTransformer;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.ProgramAlgorithmRuleTransformer;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.SpecialCaseTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.LetterGradeRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.ProgramAlgorithmRuleRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.SpecialCaseRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;


@Service
public class AlgorithmRuleService {

    @Autowired
    private ProgramAlgorithmRuleTransformer programAlgorithmRuleTransformer;
    
    @Autowired
    private ProgramAlgorithmRuleRepository programAlgorithmRuleRepository;
    
    @Autowired
    private LetterGradeTransformer letterGradeTransformer;
    
    @Autowired
    private LetterGradeRepository letterGradeRepository; 
    
    @Autowired
    private SpecialCaseTransformer specialCaseTransformer;
    
    @Autowired
    private SpecialCaseRepository specialCaseRepository;

	@Autowired
	private TranscriptMessageTransformer transcriptMessageTransformer;

	@Autowired
	private TranscriptMessageRepository transcriptMessageRepository;

	@Autowired
    WebClient webClient;
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
	GradValidation validation;

	@Autowired
	EducGradStudentGraduationApiConstants constants;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(AlgorithmRuleService.class);

    public List<ProgramAlgorithmRule> getAlgorithmRulesList(String programCode) {
		List<ProgramAlgorithmRule> responseList = programAlgorithmRuleTransformer.transformToDTO(programAlgorithmRuleRepository.getAlgorithmRulesByProgramCode(programCode));
		responseList.sort(Comparator.comparing(ProgramAlgorithmRule::getSortOrder));
		return responseList;
	}

	public List<ProgramAlgorithmRule> getAllAlgorithmRulesList() {
		List<ProgramAlgorithmRule> responseList = programAlgorithmRuleTransformer.transformToDTO(programAlgorithmRuleRepository.findAll());
		responseList.sort(Comparator.comparing(ProgramAlgorithmRule::getGraduationProgramCode)
				.thenComparing(ProgramAlgorithmRule::getSortOrder));
		return responseList;
	}

	public StudentGraduationAlgorithmData getAllAlgorithmData(String programCode) {
		StudentGraduationAlgorithmData data = new StudentGraduationAlgorithmData();
		List<ProgramAlgorithmRule> responseList = programAlgorithmRuleTransformer.transformToDTO(programAlgorithmRuleRepository.getAlgorithmRulesByProgramCode(programCode));
		responseList.sort(Comparator.comparing(ProgramAlgorithmRule::getSortOrder));
		data.setProgramAlgorithmRules(responseList);
		
		List<LetterGrade> letterGradeList = letterGradeTransformer.transformToDTO(letterGradeRepository.findAll());
		data.setLetterGrade(letterGradeList);
		
		List<SpecialCase> specialCaseList = specialCaseTransformer.transformToDTO(specialCaseRepository.findAll());
		data.setSpecialCase(specialCaseList);

		TranscriptMessage graduatedMessage = transcriptMessageTransformer.transformToDTO(transcriptMessageRepository.findByGraduationProgramCodeAndMessageTypeCode(programCode,"GRADUATED"));
		TranscriptMessage nonGraduatedMessage = transcriptMessageTransformer.transformToDTO(transcriptMessageRepository.findByGraduationProgramCodeAndMessageTypeCode(programCode,"NOT_GRADUATED"));
		data.setGraduatedMessage(graduatedMessage);
		data.setNonGraduateMessage(nonGraduatedMessage);
		data.setGradProgram(programCode);
		return data;
	}

	public List<StudentGraduationAlgorithmData> getAllAlgorithmDataList(String accessToken) {
		List<StudentGraduationAlgorithmData> sList = new ArrayList<>();
		List<GraduationProgramCode> pList = webClient.get()
				.uri(constants.getProgramList())
				.headers(h -> {
					h.setBearerAuth(accessToken);
					h.set(EducGradStudentGraduationApiConstants.CORRELATION_ID, ThreadLocalStateUtil.getCorrelationID());
				})
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<GraduationProgramCode>>(){})
				.block();
		if(pList != null && !pList.isEmpty())
			pList.forEach(p-> sList.add(getAllAlgorithmData(p.getProgramCode())));
		return sList;
	}
}
