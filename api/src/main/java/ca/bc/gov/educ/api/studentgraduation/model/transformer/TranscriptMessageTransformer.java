package ca.bc.gov.educ.api.studentgraduation.model.transformer;

import ca.bc.gov.educ.api.studentgraduation.model.dto.TranscriptMessage;
import ca.bc.gov.educ.api.studentgraduation.model.entity.TranscriptMessageEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class TranscriptMessageTransformer {

    @Autowired
    ModelMapper modelMapper;

    public TranscriptMessage transformToDTO (TranscriptMessageEntity gradProgramEntity) {
    	return modelMapper.map(gradProgramEntity, TranscriptMessage.class);
    }

    public TranscriptMessage transformToDTO ( Optional<TranscriptMessageEntity> transcriptMessageEntity ) {
    	TranscriptMessageEntity cae = new TranscriptMessageEntity();
        if (transcriptMessageEntity.isPresent())
            cae = transcriptMessageEntity.get();

        return transformToDTO(cae);
    }

	public List<TranscriptMessage> transformToDTO (Iterable<TranscriptMessageEntity> gradMessagingEntities ) {
		List<TranscriptMessage> gradMessagingList = new ArrayList<>();
        for (TranscriptMessageEntity gradMessagingEntity : gradMessagingEntities) {
        	TranscriptMessage gradMessaging = transformToDTO(gradMessagingEntity);
        	gradMessagingList.add(gradMessaging);
        }
        return gradMessagingList;
    }

    public TranscriptMessageEntity transformToEntity(TranscriptMessage gradMessaging) {
        return modelMapper.map(gradMessaging, TranscriptMessageEntity.class);
    }
}
