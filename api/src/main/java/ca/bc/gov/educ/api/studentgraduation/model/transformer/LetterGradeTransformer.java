package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.entity.LetterGradeEntity;


@Component
public class LetterGradeTransformer {

    @Autowired
    ModelMapper modelMapper;

    public LetterGrade transformToDTO (LetterGradeEntity letterGradeEntity) {
        return modelMapper.map(letterGradeEntity, LetterGrade.class);
    }

    public LetterGrade transformToDTO ( Optional<LetterGradeEntity> gradProgramEntity ) {
    	LetterGradeEntity cae = new LetterGradeEntity();
        if (gradProgramEntity.isPresent())
            cae = gradProgramEntity.get();
        
        return modelMapper.map(cae, LetterGrade.class);
    }

	public List<LetterGrade> transformToDTO (Iterable<LetterGradeEntity> letterGradeEntities ) {
		List<LetterGrade> letterGradeList = new ArrayList<>();
        for (LetterGradeEntity LetterGradeEntity : letterGradeEntities) {
        	LetterGrade grade = modelMapper.map(LetterGradeEntity, LetterGrade.class);            
        	letterGradeList.add(grade);
        }
        return letterGradeList;
    }

    public LetterGradeEntity transformToEntity(LetterGrade letterGrade) {
        return modelMapper.map(letterGrade, LetterGradeEntity.class);
    }
}
