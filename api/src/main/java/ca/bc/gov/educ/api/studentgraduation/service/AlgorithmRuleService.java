package ca.bc.gov.educ.api.studentgraduation.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import ca.bc.gov.educ.api.studentgraduation.model.dto.*;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.TranscriptMessageTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.TranscriptMessageRepository;
import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.LetterGradeTransformer;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.ProgramAlgorithmRuleTransformer;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.SpecialCaseTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.LetterGradeRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.ProgramAlgorithmRuleRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.SpecialCaseRepository;

@Slf4j
@Service
public class AlgorithmRuleService {

    private final ProgramAlgorithmRuleTransformer programAlgorithmRuleTransformer;
    private final ProgramAlgorithmRuleRepository programAlgorithmRuleRepository;
    private final LetterGradeTransformer letterGradeTransformer;
    private final LetterGradeRepository letterGradeRepository;
    private final SpecialCaseTransformer specialCaseTransformer;
    private final SpecialCaseRepository specialCaseRepository;
	private final TranscriptMessageTransformer transcriptMessageTransformer;
	private final TranscriptMessageRepository transcriptMessageRepository;
    WebClient studentGraduationApiClient;
	private final RESTService restService;
    
	EducGradStudentGraduationApiConstants constants;

	@Autowired
	public AlgorithmRuleService(ProgramAlgorithmRuleTransformer programAlgorithmRuleTransformer,
								ProgramAlgorithmRuleRepository programAlgorithmRuleRepository,
								LetterGradeTransformer letterGradeTransformer,
								LetterGradeRepository letterGradeRepository,
								SpecialCaseTransformer specialCaseTransformer,
								SpecialCaseRepository specialCaseRepository,
								TranscriptMessageTransformer transcriptMessageTransformer,
								TranscriptMessageRepository transcriptMessageRepository,
								@Qualifier("studentGraduationApiClient") WebClient studentGraduationApiClient,
								RESTService restService, EducGradStudentGraduationApiConstants constants) {
		this.programAlgorithmRuleTransformer = programAlgorithmRuleTransformer;
		this.programAlgorithmRuleRepository = programAlgorithmRuleRepository;
		this.letterGradeTransformer = letterGradeTransformer;
		this.letterGradeRepository = letterGradeRepository;
		this.specialCaseTransformer = specialCaseTransformer;
		this.specialCaseRepository = specialCaseRepository;
		this.transcriptMessageTransformer = transcriptMessageTransformer;
		this.transcriptMessageRepository = transcriptMessageRepository;
		this.studentGraduationApiClient = studentGraduationApiClient;
		this.restService = restService;
		this.constants = constants;
	}

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

	public List<StudentGraduationAlgorithmData> getAllAlgorithmDataList() {
		List<StudentGraduationAlgorithmData> sList = new ArrayList<>();
		List<GraduationProgramCode> pList = restService.get(
				String.format(constants.getProgramList()),
				new ParameterizedTypeReference<List<GraduationProgramCode>>() {
				}, studentGraduationApiClient);
		if(pList != null && !pList.isEmpty())
			pList.forEach(p-> sList.add(getAllAlgorithmData(p.getProgramCode())));
		return sList;
	}
}
