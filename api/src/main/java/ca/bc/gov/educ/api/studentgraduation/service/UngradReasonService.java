package ca.bc.gov.educ.api.studentgraduation.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.UngradReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.UngradReasonTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.UngradReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;

@Service
public class UngradReasonService {

	@Autowired
	private UngradReasonRepository ungradReasonRepository;

	@Autowired
	private UngradReasonTransformer ungradReasonTransformer;
	
	@Autowired
	private StudentUngradReasonService studentUngradReasonService;

	@Autowired
	GradValidation validation;	
	
	@Autowired
    WebClient webClient;
    
    @Autowired
    RestTemplate restTemplate;

	private static Logger logger = LoggerFactory.getLogger(UngradReasonService.class);
	private static final String CREATED_BY="createdBy";
	private static final String CREATED_TIMESTAMP="createdTimestamp";


	@Transactional
	public List<UngradReason> getAllUngradReasonCodeList() {
		return ungradReasonTransformer.transformToDTO(ungradReasonRepository.findAll());
	}

	@Transactional
	public UngradReason getSpecificUngradReasonCode(String reasonCode) {
		Optional<UngradReasonEntity> entity = ungradReasonRepository.findById(StringUtils.toRootUpperCase(reasonCode));
		if (entity.isPresent()) {
			return ungradReasonTransformer.transformToDTO(entity);
		} else {
			return null;
		}
	}
	
	public UngradReason createUngradReason(@Valid UngradReason ungradReason) {
		UngradReasonEntity toBeSavedObject = ungradReasonTransformer.transformToEntity(ungradReason);
		Optional<UngradReasonEntity> existingObjectCheck = ungradReasonRepository.findById(ungradReason.getCode());
		if(existingObjectCheck.isPresent()) {
			validation.addErrorAndStop(String.format("Reason Code [%s] already exists",ungradReason.getCode()));
			return ungradReason;			
		}else {
			return ungradReasonTransformer.transformToDTO(ungradReasonRepository.save(toBeSavedObject));
		}	
	}

	public UngradReason updateUngradReason(@Valid UngradReason ungradReason) {
		Optional<UngradReasonEntity> gradUngradReasonOptional = ungradReasonRepository.findById(ungradReason.getCode());
		UngradReasonEntity sourceObject = ungradReasonTransformer.transformToEntity(ungradReason);
		if(gradUngradReasonOptional.isPresent()) {
			UngradReasonEntity gradEnity = gradUngradReasonOptional.get();			
			BeanUtils.copyProperties(sourceObject,gradEnity,CREATED_BY,CREATED_TIMESTAMP);
    		return ungradReasonTransformer.transformToDTO(ungradReasonRepository.save(gradEnity));
		}else {
			validation.addErrorAndStop(String.format("Reason Code [%s] does not exists",ungradReason.getCode()));
			return ungradReason;
		}
	}

	public int deleteUngradReason(@Valid String reasonCode) {
		Boolean isPresent = studentUngradReasonService.getStudentUngradReasons(reasonCode);
		if(isPresent) {
			validation.addErrorAndStop(
					String.format("This Ungrad Reason [%s] cannot be deleted as some students have this reason associated with them.",reasonCode));
			return 0;
		}else {
			ungradReasonRepository.deleteById(reasonCode);
			return 1;
		}
		
	}
}
