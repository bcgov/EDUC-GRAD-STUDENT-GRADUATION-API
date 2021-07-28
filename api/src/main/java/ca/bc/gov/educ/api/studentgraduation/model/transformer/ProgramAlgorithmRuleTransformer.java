package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.bc.gov.educ.api.studentgraduation.model.dto.ProgramAlgorithmRule;
import ca.bc.gov.educ.api.studentgraduation.model.entity.ProgramAlgorithmRuleEntity;


@Component
public class ProgramAlgorithmRuleTransformer {

    @Autowired
    ModelMapper modelMapper;

    public ProgramAlgorithmRule transformToDTO (ProgramAlgorithmRuleEntity programAlgorithmRuleEntity) {
    	return modelMapper.map(programAlgorithmRuleEntity, ProgramAlgorithmRule.class);
    }

    public ProgramAlgorithmRule transformToDTO ( Optional<ProgramAlgorithmRuleEntity> programAlgorithmRuleEntity ) {
    	ProgramAlgorithmRuleEntity cae = new ProgramAlgorithmRuleEntity();
        if (programAlgorithmRuleEntity.isPresent())
            cae = programAlgorithmRuleEntity.get();

        return modelMapper.map(cae, ProgramAlgorithmRule.class);
    }

	public List<ProgramAlgorithmRule> transformToDTO (List<ProgramAlgorithmRuleEntity> gradCountryEntities ) {
		List<ProgramAlgorithmRule> gradCountryList = new ArrayList<>();
        for (ProgramAlgorithmRuleEntity gradCountryEntity : gradCountryEntities) {
        	ProgramAlgorithmRule gradCountry = modelMapper.map(gradCountryEntity, ProgramAlgorithmRule.class);            
        	gradCountryList.add(gradCountry);
        }
        return gradCountryList;
    }

    public ProgramAlgorithmRuleEntity transformToEntity(ProgramAlgorithmRule gradCountry) {
        return modelMapper.map(gradCountry, ProgramAlgorithmRuleEntity.class);
    }
}
