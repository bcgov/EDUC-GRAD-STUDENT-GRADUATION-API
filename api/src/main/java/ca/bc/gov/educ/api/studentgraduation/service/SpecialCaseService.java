package ca.bc.gov.educ.api.studentgraduation.service;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.SpecialCase;
import ca.bc.gov.educ.api.studentgraduation.model.entity.SpecialCaseCodeEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.SpecialCaseTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.SpecialCaseRepository;
import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;

@Service
public class SpecialCaseService {

    @Autowired
    private SpecialCaseTransformer specialCaseTransformer;
    
    @Autowired
    private SpecialCaseRepository specialCaseRepository; 
    
    @Autowired
	GradValidation validation;
    
    @Autowired
	EducGradStudentGraduationApiConstants gradStudentGraduationApiConstants;
     
        
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    WebClient webClient;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SpecialCaseService.class);

    public List<SpecialCase> getAllSpecialCaseList() {
	        return specialCaseTransformer.transformToDTO(specialCaseRepository.findAll());
	    }

	public SpecialCase getSpecificSpecialCase(String specialCode) {
		Optional<SpecialCaseCodeEntity> gradResponse = specialCaseRepository.findById(specialCode); 
		if(gradResponse.isPresent()) {
			return specialCaseTransformer.transformToDTO(gradResponse.get());
		}
		return null;
	}
}
