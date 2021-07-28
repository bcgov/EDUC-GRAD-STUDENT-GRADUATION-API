package ca.bc.gov.educ.api.studentgraduation.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUngradReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.StudentUngradReasonTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.StudentUngradReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;


@Service
public class StudentUngradReasonService {

    @Autowired
    private StudentUngradReasonTransformer studentUngradReasonTransformer;
    
    @Autowired
    private StudentUngradReasonRepository studentUngradReasonRepository; 
    
    @Autowired
    private UngradReasonService ungradReasonService;
    
    @Autowired
    WebClient webClient;
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
	GradValidation validation;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(StudentUngradReasonService.class);

    @Transactional
    public List<StudentUngradReason> getAllStudentUngradReasonsList(UUID studentID) {
	    return studentUngradReasonTransformer.transformToDTO(studentUngradReasonRepository.findByGraduationStudentRecordID(studentID));
	}

    public boolean getStudentUngradReasons(String reasonCode) {
		List<StudentUngradReasonEntity> gradList = studentUngradReasonRepository.existsByUngradReasonCode(reasonCode);
		return !gradList.isEmpty();
	}

	public StudentUngradReason createStudentUngradReason(@Valid StudentUngradReason studentUngradReason) {
		StudentUngradReasonEntity toBeSavedObject = studentUngradReasonTransformer.transformToEntity(studentUngradReason);
		if(studentUngradReason.getStudentUngradReasonID() != null) {
			Optional<StudentUngradReasonEntity> existingObjectCheck = studentUngradReasonRepository.findById(studentUngradReason.getStudentUngradReasonID());
			if(existingObjectCheck.isPresent()) {
				validation.addErrorAndStop("Cannot update an existing student ungrad reason");
				return studentUngradReason;			
			}
			return null;
		}else {
			UngradReason ungradReasonObj = ungradReasonService.getSpecificUngradReasonCode(studentUngradReason.getUngradReasonCode());
    		if(ungradReasonObj != null) {
    			return studentUngradReasonTransformer.transformToDTO(studentUngradReasonRepository.save(toBeSavedObject));
    		}else {
    			validation.addErrorAndStop(String.format("Invalid Ungrad Reason Code [%s]",studentUngradReason.getUngradReasonCode()));
    			return studentUngradReason;
    		}
				
		}
	}
}
