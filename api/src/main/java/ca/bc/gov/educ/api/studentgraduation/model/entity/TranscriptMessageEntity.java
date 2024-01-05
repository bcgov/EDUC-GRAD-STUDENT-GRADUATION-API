package ca.bc.gov.educ.api.studentgraduation.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Immutable;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
@Immutable
@Entity
@Table(name = "TRANSCRIPT_MESSAGE")
public class TranscriptMessageEntity extends BaseEntity {
   
	@Id
	@Column(name = "TRANSCRIPT_MESSAGE_ID", nullable = false)
    private UUID transcriptMessageID; 
	
	@Column(name = "GRADUATION_PROGRAM_CODE", nullable = false)
    private String graduationProgramCode; 
	
	@Column(name = "MESSAGE_TYPE_CODE", nullable = false)
    private String messageTypeCode;
	
	@Column(name = "GRAD_MAIN_MESSAGE", nullable = false)
    private String gradMainMessage;
	
	@Column(name = "GRAD_DATE_MESSAGE", nullable = false)
    private String gradDateMessage;
	
	@Column(name = "HONOUR_NOTE", nullable = false)
    private String honourNote;
	
	@Column(name = "AD_IB_PROGRAM_MESSAGE", nullable = false)
    private String adIBProgramMessage;
	
	@Column(name = "FRENCH_IMMERSION_MESSAGE", nullable = false)
    private String frenchImmersionMessage;
	
	@Column(name = "CAREER_PROGRAM_MESSAGE", nullable = false)
    private String careerProgramMessage;

	@Column(name = "GRAD_PROJECTED_MESSAGE", nullable = false)
	private String gradProjectedMessage;

	@Column(name = "HONOUR_PROJECTED_NOTE", nullable = false)
	private String honourProjectedNote;

	@Column(name = "GRADUATION_SCHOOL", nullable = false)
	private String graduationSchool;



}