package ca.bc.gov.educ.api.studentgraduation.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@Immutable
@Entity
@Table(name = "LETTER_GRADE")
public class LetterGradeEntity extends BaseEntity {
   
	@Id
	@Column(name = "LETTER_GRADE", nullable = false)
    private String grade; 
	
	@Column(name = "GPA_MARK_VALUE", nullable = true)
    private String gpaMarkValue; 
	
	@Column(name = "PASS_FLAG", nullable = true)
    private String passFlag;
	
	@Column(name = "DESCRIPTION", nullable = true)
    private String description;

	@Column(name = "LABEL", nullable = true)
	private String label;

	@Column(name = "PERCENT_RANGE_HIGH", nullable = true)
	private Integer percentRangeHigh;

	@Column(name = "PERCENT_RANGE_LOW", nullable = true)
	private Integer percentRangeLow;

	@Column(name = "EXPIRY_DATE", nullable = true)
	private Date expiryDate;

}