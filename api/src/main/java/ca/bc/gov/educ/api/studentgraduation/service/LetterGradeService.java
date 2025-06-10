package ca.bc.gov.educ.api.studentgraduation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.entity.LetterGradeEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.LetterGradeTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.LetterGradeRepository;

@Service
public class LetterGradeService {
    
    private final LetterGradeTransformer letterGradeTransformer;
    private final LetterGradeRepository letterGradeRepository;

	@Autowired
	public LetterGradeService(LetterGradeTransformer letterGradeTransformer, LetterGradeRepository letterGradeRepository) {
		this.letterGradeTransformer = letterGradeTransformer;
		this.letterGradeRepository = letterGradeRepository;
	}

	public List<LetterGrade> getAllLetterGradesList() {
		return letterGradeTransformer.transformToDTO(letterGradeRepository.findAll());
	}

	public LetterGrade getSpecificLetterGrade(String letterGrade) {
		Optional<LetterGradeEntity> gradResponse =letterGradeRepository.findById(letterGrade);
        return gradResponse.map(letterGradeTransformer::transformToDTO).orElse(null);
    }
}
