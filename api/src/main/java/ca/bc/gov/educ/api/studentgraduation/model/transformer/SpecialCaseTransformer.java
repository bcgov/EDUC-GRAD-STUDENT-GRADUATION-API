package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.bc.gov.educ.api.studentgraduation.model.dto.SpecialCase;
import ca.bc.gov.educ.api.studentgraduation.model.entity.SpecialCaseCodeEntity;

@Component
public class SpecialCaseTransformer {

    @Autowired
    ModelMapper modelMapper;

    public SpecialCase transformToDTO (SpecialCaseCodeEntity gradProgramEntity) {
    	return modelMapper.map(gradProgramEntity, SpecialCase.class);
    }

    public SpecialCase transformToDTO ( Optional<SpecialCaseCodeEntity> gradProgramEntity ) {
    	SpecialCaseCodeEntity cae = new SpecialCaseCodeEntity();
        if (gradProgramEntity.isPresent())
            cae = gradProgramEntity.get();
        
        return modelMapper.map(cae, SpecialCase.class);
    }

	public List<SpecialCase> transformToDTO (List<SpecialCaseCodeEntity> gradSpecialCaseEntities ) {
		List<SpecialCase> gradSpecialCaseList = new ArrayList<>();
        for (SpecialCaseCodeEntity gradSpecialCaseCodeEntity : gradSpecialCaseEntities) {
        	SpecialCase gradSpecialCase = modelMapper.map(gradSpecialCaseCodeEntity, SpecialCase.class);            
        	gradSpecialCaseList.add(gradSpecialCase);
        }
        return gradSpecialCaseList;
    }

    public SpecialCaseCodeEntity transformToEntity(SpecialCase gradSpecialCase) {
        return modelMapper.map(gradSpecialCase, SpecialCaseCodeEntity.class);
    }
}
