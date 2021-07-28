package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.UngradReasonEntity;


@Component
public class UngradReasonTransformer {

    @Autowired
    ModelMapper modelMapper;

    public UngradReason transformToDTO (UngradReasonEntity ungradReasonEntity) {
        return modelMapper.map(ungradReasonEntity, UngradReason.class);
    }

    public UngradReason transformToDTO ( Optional<UngradReasonEntity> ungradReasonEntity ) {
    	UngradReasonEntity cae = new UngradReasonEntity();
        if (ungradReasonEntity.isPresent())
            cae = ungradReasonEntity.get();

        return modelMapper.map(cae, UngradReason.class);
    }

	public List<UngradReason> transformToDTO (Iterable<UngradReasonEntity> gradUngradReasonsEntities ) {
		List<UngradReason> gradUngradReasonsList = new ArrayList<>();
        for (UngradReasonEntity gradUngradReasonsEntity : gradUngradReasonsEntities) {
        	UngradReason gradUngradReasons = modelMapper.map(gradUngradReasonsEntity, UngradReason.class);            
        	gradUngradReasonsList.add(gradUngradReasons);
        }
        return gradUngradReasonsList;
    }

    public UngradReasonEntity transformToEntity(UngradReason ungradReason) {
        return modelMapper.map(ungradReason, UngradReasonEntity.class);
    }
}
