package ca.bc.gov.educ.api.studentgraduation.service;


import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.entity.LetterGradeEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.LetterGradeTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.LetterGradeRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;

@Service
@AllArgsConstructor
public class LetterGradeService {
    
    private LetterGradeTransformer letterGradeTransformer;
    
    private LetterGradeRepository letterGradeRepository;
    
	GradValidation validation;
       
    RestTemplate restTemplate;
    
    WebClient webClient;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(LetterGradeService.class);

	public List<LetterGrade> getAllLetterGradesList() {
		return letterGradeTransformer.transformToDTO(letterGradeRepository.findAll());
	}

	public LetterGrade getSpecificLetterGrade(String letterGrade) {
		Optional<LetterGradeEntity> gradResponse =letterGradeRepository.findById(letterGrade); 
		if(gradResponse.isPresent()) {
			return letterGradeTransformer.transformToDTO(gradResponse.get());
		}
		return null;
	}
}
