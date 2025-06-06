package ca.bc.gov.educ.api.studentgraduation.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUndoCompletionReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.model.transformer.StudentUndoCompletionReasonTransformer;
import ca.bc.gov.educ.api.studentgraduation.repository.StudentUndoCompletionReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;


@Service
public class StudentUndoCompletionReasonService {

    @Autowired
    private StudentUndoCompletionReasonTransformer studentUndoCompletionReasonTransformer;
    
    @Autowired
    private StudentUndoCompletionReasonRepository studentUndoCompletionReasonRepository; 
    
    @Autowired
    private UndoCompletionReasonService undoCompletionReasonService;
    
    @Autowired
	GradValidation validation;

    @SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(StudentUndoCompletionReasonService.class);

    @Transactional
    public List<StudentUndoCompletionReason> getAllStudentUndoCompletionReasonsList(UUID studentID) {
	    return studentUndoCompletionReasonTransformer.transformToDTO(studentUndoCompletionReasonRepository.findByGraduationStudentRecordID(studentID));
	}

	public StudentUndoCompletionReason createStudentUndoCompletionReason(@Valid StudentUndoCompletionReason studentUndoCompletionReason) {
		StudentUndoCompletionReasonEntity toBeSavedObject = studentUndoCompletionReasonTransformer.transformToEntity(studentUndoCompletionReason);
		if(studentUndoCompletionReason.getStudentUndoCompletionReasonID() != null) {
			Optional<StudentUndoCompletionReasonEntity> existingObjectCheck = studentUndoCompletionReasonRepository.findById(studentUndoCompletionReason.getStudentUndoCompletionReasonID());
			if(existingObjectCheck.isPresent()) {
				validation.addErrorAndStop("Cannot update an existing student ungrad reason");
				return studentUndoCompletionReason;			
			}
			return null;
		}else {
			UndoCompletionReason undoCompletionReasonObj = undoCompletionReasonService.getSpecificUndoCompletionReasonCode(studentUndoCompletionReason.getUndoCompletionReasonCode());
    		if(undoCompletionReasonObj != null) {
    			return studentUndoCompletionReasonTransformer.transformToDTO(studentUndoCompletionReasonRepository.save(toBeSavedObject));
    		}else {
    			validation.addErrorAndStop(String.format("Invalid Ungrad Reason Code [%s]",studentUndoCompletionReason.getUndoCompletionReasonCode()));
    			return studentUndoCompletionReason;
    		}
				
		}
	}
}
