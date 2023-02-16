package ca.bc.gov.educ.api.studentgraduation.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Immutable
@Entity
@Table(name = "SPECIAL_CASE_CODE")
public class SpecialCaseCodeEntity extends BaseEntity {
   	
	@Id
	@Column(name = "SPECIAL_CASE_CODE", nullable = false)
    private String spCase; 
	
	@Column(name = "LABEL", nullable = true)
    private String label; 
	
	@Column(name = "DISPLAY_ORDER", nullable = true)
    private int displayOrder; 
	
	@Column(name = "DESCRIPTION", nullable = true)
    private String description;
	
	@Column(name = "PASS_FLAG", nullable = true)
    private String passFlag;
	
	@Column(name = "EFFECTIVE_DATE", nullable = true)
    private Date effectiveDate; 
	
	@Column(name = "EXPIRY_DATE", nullable = true)
    private Date expiryDate;	
}