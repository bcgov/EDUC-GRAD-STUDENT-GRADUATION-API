package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUndoCompletionReasonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class StudentUndoCompletionReasonTransformer {

    @Autowired
    ModelMapper modelMapper;

    public StudentUndoCompletionReason transformToDTO (StudentUndoCompletionReasonEntity studentUndoCompletionReasonEntity) {
    	return modelMapper.map(studentUndoCompletionReasonEntity, StudentUndoCompletionReason.class);
    }

    public StudentUndoCompletionReason transformToDTO ( Optional<StudentUndoCompletionReasonEntity> studentUndoCompletionReasonEntity ) {
    	StudentUndoCompletionReasonEntity cae = new StudentUndoCompletionReasonEntity();
        if (studentUndoCompletionReasonEntity.isPresent())
            cae = studentUndoCompletionReasonEntity.get();

        return modelMapper.map(cae, StudentUndoCompletionReason.class);
    }

	public List<StudentUndoCompletionReason> transformToDTO (List<StudentUndoCompletionReasonEntity> studentUndoCompletionReasonEntities ) {
		List<StudentUndoCompletionReason> gradCountryList = new ArrayList<>();
        for (StudentUndoCompletionReasonEntity gradCountryEntity : studentUndoCompletionReasonEntities) {
        	StudentUndoCompletionReason gradCountry = modelMapper.map(gradCountryEntity, StudentUndoCompletionReason.class);
        	gradCountryList.add(gradCountry);
        }
        return gradCountryList;
    }

    public StudentUndoCompletionReasonEntity transformToEntity(StudentUndoCompletionReason gradCountry) {
        return modelMapper.map(gradCountry, StudentUndoCompletionReasonEntity.class);
    }
}
