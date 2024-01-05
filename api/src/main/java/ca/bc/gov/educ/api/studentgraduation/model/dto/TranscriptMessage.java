package ca.bc.gov.educ.api.studentgraduation.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class TranscriptMessage extends BaseModel {

	private UUID transcriptMessageID; 
	private String programCode; 
	private String messageTypeCode;
	private String gradMainMessage;
	private String gradDateMessage;
	private String honourNote;
	private String adIBProgramMessage;
	private String frenchImmersionMessage;
	private String careerProgramMessage;
	private String gradProjectedMessage;
	private String honourProjectedNote;
	private String graduationSchool;

	@Override
	public String toString() {
		return "TranscriptMessage{" +
				"transcriptMessageID=" + transcriptMessageID +
				", programCode='" + programCode + '\'' +
				", messageTypeCode='" + messageTypeCode + '\'' +
				", gradMainMessage='" + gradMainMessage + '\'' +
				", gradDateMessage='" + gradDateMessage + '\'' +
				", honourNote='" + honourNote + '\'' +
				", adIBProgramMessage='" + adIBProgramMessage + '\'' +
				", frenchImmersionMessage='" + frenchImmersionMessage + '\'' +
				", careerProgramMessage='" + careerProgramMessage + '\'' +
				", gradProjectedMessage='" + gradProjectedMessage + '\'' +
				", honourProjectedNote='" + honourProjectedNote + '\'' +
				", graduationSchool='"+graduationSchool+'\'' +
				'}';
	}
}