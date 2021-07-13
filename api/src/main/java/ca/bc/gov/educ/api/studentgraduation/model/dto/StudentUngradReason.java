package ca.bc.gov.educ.api.studentgraduation.model.dto;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class StudentUngradReason extends BaseModel {

	private UUID studentUngradReasonID; 
	private UUID graduationStudentRecordID; 
	private String ungradReasonCode;
	private String ungradReasonDescription;	
}
