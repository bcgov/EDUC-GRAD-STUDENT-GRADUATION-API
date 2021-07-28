package ca.bc.gov.educ.api.studentgraduation.model.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "STUDENT_UNGRAD_REASON")
public class StudentUngradReasonEntity extends BaseEntity {
   	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "STUDENT_UNGRAD_REASON_ID", nullable = false)
    private UUID studentUngradReasonID; 
	
	@Column(name = "GRADUATION_STUDENT_RECORD_ID", nullable = false)
    private UUID graduationStudentRecordID; 
	
	@Column(name = "UNGRAD_REASON_CODE", nullable = true)
    private String ungradReasonCode;
	
	@Column(name="UNGRAD_REASON_DESCRIPTION", nullable = true)
	private String ungradReasonDescription;	
	
}