package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUngradReasonEntity;


@Component
public class StudentUngradReasonTransformer {

    @Autowired
    ModelMapper modelMapper;

    public StudentUngradReason transformToDTO (StudentUngradReasonEntity studentUngradReasonEntity) {
    	return modelMapper.map(studentUngradReasonEntity, StudentUngradReason.class);
    }

    public StudentUngradReason transformToDTO ( Optional<StudentUngradReasonEntity> studentUngradReasonEntity ) {
    	StudentUngradReasonEntity cae = new StudentUngradReasonEntity();
        if (studentUngradReasonEntity.isPresent())
            cae = studentUngradReasonEntity.get();

        return modelMapper.map(cae, StudentUngradReason.class);
    }

	public List<StudentUngradReason> transformToDTO (List<StudentUngradReasonEntity> gradCountryEntities ) {
		List<StudentUngradReason> gradCountryList = new ArrayList<>();
        for (StudentUngradReasonEntity gradCountryEntity : gradCountryEntities) {
        	StudentUngradReason gradCountry = modelMapper.map(gradCountryEntity, StudentUngradReason.class);            
        	gradCountryList.add(gradCountry);
        }
        return gradCountryList;
    }

    public StudentUngradReasonEntity transformToEntity(StudentUngradReason gradCountry) {
        return modelMapper.map(gradCountry, StudentUngradReasonEntity.class);
    }
}
