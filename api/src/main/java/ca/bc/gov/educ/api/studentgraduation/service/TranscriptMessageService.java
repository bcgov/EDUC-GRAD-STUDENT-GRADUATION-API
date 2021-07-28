package ca.bc.gov.educ.api.studentgraduation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.TranscriptMessage;
import ca.bc.gov.educ.api.studentgraduation.model.entity.TranscriptMessageEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.TranscriptMessageTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.TranscriptMessageRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
@Service
public class TranscriptMessageService {

	@Autowired
	private TranscriptMessageRepository transcriptMessageRepository;

	@Autowired
	private TranscriptMessageTransformer transcriptMessageTransformer;

	@Autowired
	GradValidation validation;
	
	@Autowired
    WebClient webClient;
    
	public List<TranscriptMessage> getAllTranscriptMessageList() {
		return transcriptMessageTransformer.transformToDTO(transcriptMessageRepository.findAll());
	}

	public TranscriptMessage getSpecificTranscriptMessageCode(String pgmCode, String msgType) {
		Optional<TranscriptMessageEntity> entity = transcriptMessageRepository.findByGraduationProgramCodeAndMessageTypeCode(pgmCode,
				msgType);
		if (entity.isPresent()) {
			return transcriptMessageTransformer.transformToDTO(entity);
		} else {
			return null;
		}
	}	
}
