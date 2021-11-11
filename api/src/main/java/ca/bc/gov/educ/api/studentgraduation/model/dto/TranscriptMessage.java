package ca.bc.gov.educ.api.studentgraduation.model.dto;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class TranscriptMessage extends BaseModel{

	private UUID transcriptMessageID; 
	private String programCode; 
	private String messageTypeCode;
	private String gradMainMessage;
	private String gradDateMessage;
	private String honourNote;
	private String adIBProgramMessage;
	private String programCadre;
	private String careerProgramMessage;
	private String gradProjectedMessage;
	private String honourProjectedNote;

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
				", programCadre='" + programCadre + '\'' +
				", careerProgramMessage='" + careerProgramMessage + '\'' +
				", gradProjectedMessage='" + gradProjectedMessage + '\'' +
				", honourProjectedNote='" + honourProjectedNote + '\'' +
				'}';
	}
}