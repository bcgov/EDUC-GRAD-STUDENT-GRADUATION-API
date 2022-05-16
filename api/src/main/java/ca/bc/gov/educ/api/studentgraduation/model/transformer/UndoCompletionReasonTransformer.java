package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.UndoCompletionReasonEntity;


@Component
public class UndoCompletionReasonTransformer {

    @Autowired
    ModelMapper modelMapper;

    public UndoCompletionReason transformToDTO (UndoCompletionReasonEntity ungradReasonEntity) {
        return modelMapper.map(ungradReasonEntity, UndoCompletionReason.class);
    }

    public UndoCompletionReason transformToDTO ( Optional<UndoCompletionReasonEntity> ungradReasonEntity ) {
    	UndoCompletionReasonEntity cae = new UndoCompletionReasonEntity();
        if (ungradReasonEntity.isPresent())
            cae = ungradReasonEntity.get();

        return modelMapper.map(cae, UndoCompletionReason.class);
    }

	public List<UndoCompletionReason> transformToDTO (Iterable<UndoCompletionReasonEntity> gradUndoCompletionReasonsEntities ) {
		List<UndoCompletionReason> gradUndoCompletionReasonsList = new ArrayList<>();
        for (UndoCompletionReasonEntity gradUndoCompletionReasonsEntity : gradUndoCompletionReasonsEntities) {
        	UndoCompletionReason gradUndoCompletionReasons = modelMapper.map(gradUndoCompletionReasonsEntity, UndoCompletionReason.class);            
        	gradUndoCompletionReasonsList.add(gradUndoCompletionReasons);
        }
        return gradUndoCompletionReasonsList;
    }

    public UndoCompletionReasonEntity transformToEntity(UndoCompletionReason ungradReason) {
        return modelMapper.map(ungradReason, UndoCompletionReasonEntity.class);
    }
}
