package ca.bc.gov.educ.api.studentgraduation.service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.dto.ProgramAlgorithmRule;
import ca.bc.gov.educ.api.studentgraduation.model.dto.SpecialCase;
import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentGraduationAlgorithmData;
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
    WebClient webClient;
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
	GradValidation validation;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(AlgorithmRuleService.class);

    public List<ProgramAlgorithmRule> getAlgorithmRulesList(String programCode) {
		List<ProgramAlgorithmRule> responseList = programAlgorithmRuleTransformer.transformToDTO(programAlgorithmRuleRepository.getAlgorithmRulesByProgramCode(programCode));
		Collections.sort(responseList, Comparator.comparing(ProgramAlgorithmRule::getSortOrder));
		return responseList;
	}

	public List<ProgramAlgorithmRule> getAllAlgorithmRulesList() {
		List<ProgramAlgorithmRule> responseList = programAlgorithmRuleTransformer.transformToDTO(programAlgorithmRuleRepository.findAll());
		Collections.sort(responseList, Comparator.comparing(ProgramAlgorithmRule::getGraduationProgramCode)
				 .thenComparing(ProgramAlgorithmRule::getSortOrder));
		return responseList;
	}

	public StudentGraduationAlgorithmData getAllAlgorithmData(String programCode) {
		StudentGraduationAlgorithmData data = new StudentGraduationAlgorithmData();
		List<ProgramAlgorithmRule> responseList = programAlgorithmRuleTransformer.transformToDTO(programAlgorithmRuleRepository.getAlgorithmRulesByProgramCode(programCode));
		Collections.sort(responseList, Comparator.comparing(ProgramAlgorithmRule::getSortOrder));
		data.setProgramAlgorithmRules(responseList);
		
		List<LetterGrade> letterGradeList = letterGradeTransformer.transformToDTO(letterGradeRepository.findAll());
		data.setLetterGrade(letterGradeList);
		
		List<SpecialCase> specialCaseList = specialCaseTransformer.transformToDTO(specialCaseRepository.findAll());
		data.setSpecialCase(specialCaseList);
		
		return data;
	}
}
