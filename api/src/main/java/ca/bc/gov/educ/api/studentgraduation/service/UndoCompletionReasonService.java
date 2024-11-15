package ca.bc.gov.educ.api.studentgraduation.service;

import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUndoCompletionReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.model.entity.UndoCompletionReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.UndoCompletionReasonTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.StudentUndoCompletionReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.UndoCompletionReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UndoCompletionReasonService {

	@Autowired
	private UndoCompletionReasonRepository undoCompletionReasonRepository;

	@Autowired
	private UndoCompletionReasonTransformer undoCompletionReasonTransformer;

	@Autowired
	private StudentUndoCompletionReasonRepository studentUndoCompletionReasonRepository;

	@Autowired
	GradValidation validation;	
	
	@Autowired
    WebClient webClient;
    
    @Autowired
    RestTemplate restTemplate;

	private static final String CREATED_BY="createdBy";
	private static final String CREATED_TIMESTAMP="createdTimestamp";
	private static Logger logger = LoggerFactory.getLogger(UndoCompletionReasonService.class);


	@Transactional
	public List<UndoCompletionReason> getAllUndoCompletionReasonCodeList() {
		long start1 = System.nanoTime();
		List<UndoCompletionReasonEntity> undoCompletionReasonEntities = undoCompletionReasonRepository.findAll();
		long end1 = System.nanoTime();
		long totalTime = (end1-start1)/1000000;
		if(totalTime > 500){
			logger.debug("Database: undoCompletionReasonRepository.findAll() took longer than 500ms: " + totalTime);
		}
		long start2 = System.nanoTime();
		List<UndoCompletionReason> undoCompletionReasons = undoCompletionReasonTransformer.transformToDTO(undoCompletionReasonEntities);
		long end2 = System.nanoTime();
		long totalTime2 = (end2-start2)/1000000;
		if(totalTime2 > 500){
			logger.debug("DTO Transform: undoCompletionReasonTransformer.transformToDTO took longer than 500ms: " + totalTime2);
		}
		return undoCompletionReasons;
	}

	@Transactional
	public UndoCompletionReason getSpecificUndoCompletionReasonCode(String reasonCode) {
		Optional<UndoCompletionReasonEntity> entity = undoCompletionReasonRepository.findById(StringUtils.toRootUpperCase(reasonCode));
		if (entity.isPresent()) {
			return undoCompletionReasonTransformer.transformToDTO(entity);
		} else {
			return null;
		}
	}
	
	public UndoCompletionReason createUndoCompletionReason(@Valid UndoCompletionReason undoCompletionReason) {
		UndoCompletionReasonEntity toBeSavedObject = undoCompletionReasonTransformer.transformToEntity(undoCompletionReason);
		Optional<UndoCompletionReasonEntity> existingObjectCheck = undoCompletionReasonRepository.findById(undoCompletionReason.getCode());
		if(existingObjectCheck.isPresent()) {
			validation.addErrorAndStop(String.format("Reason Code [%s] already exists",undoCompletionReason.getCode()));
			return undoCompletionReason;			
		}else {
			return undoCompletionReasonTransformer.transformToDTO(undoCompletionReasonRepository.save(toBeSavedObject));
		}	
	}

	public UndoCompletionReason updateUndoCompletionReason(@Valid UndoCompletionReason undoCompletionReason) {
		Optional<UndoCompletionReasonEntity> gradUndoCompletionReasonOptional = undoCompletionReasonRepository.findById(undoCompletionReason.getCode());
		UndoCompletionReasonEntity sourceObject = undoCompletionReasonTransformer.transformToEntity(undoCompletionReason);
		if(gradUndoCompletionReasonOptional.isPresent()) {
			UndoCompletionReasonEntity gradEnity = gradUndoCompletionReasonOptional.get();			
			BeanUtils.copyProperties(sourceObject,gradEnity,CREATED_BY,CREATED_TIMESTAMP);
    		return undoCompletionReasonTransformer.transformToDTO(undoCompletionReasonRepository.save(gradEnity));
		}else {
			validation.addErrorAndStop(String.format("Reason Code [%s] does not exists",undoCompletionReason.getCode()));
			return undoCompletionReason;
		}
	}

	public int deleteUndoCompletionReason(@Valid String reasonCode) {
		boolean isPresent = getStudentUndoCompletionReasons(reasonCode);
		if(isPresent) {
			validation.addErrorAndStop(
					String.format("This Ungrad Reason [%s] cannot be deleted as some students have this reason associated with them.",reasonCode));
			return 0;
		}else {
			undoCompletionReasonRepository.deleteById(reasonCode);
			return 1;
		}
		
	}

	private boolean getStudentUndoCompletionReasons(String reasonCode) {
		List<StudentUndoCompletionReasonEntity> gradList = studentUndoCompletionReasonRepository.existsByUndoCompletionReasonCode(reasonCode);
		return !gradList.isEmpty();
	}
}
