package ca.bc.gov.educ.api.studentgraduation.model.dto;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class StudentUndoCompletionReason extends BaseModel {

	private UUID studentUndoCompletionReasonID;
	private UUID graduationStudentRecordID; 
	private String undoCompletionReasonCode;
	private String undoCompletionReasonDescription;
}
