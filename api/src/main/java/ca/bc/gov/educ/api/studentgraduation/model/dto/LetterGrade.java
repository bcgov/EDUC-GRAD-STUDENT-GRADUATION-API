package ca.bc.gov.educ.api.studentgraduation.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@Component
public class LetterGrade extends BaseModel {

	private String grade; 
	private String gpaMarkValue; 
	private String passFlag;
	private String description;
	private String label;
	private Integer percentRangeHigh;
	private Integer percentRangeLow;
	private Date expiryDate;
	private Date effectiveDate;

	@Override
	public String toString() {
		return "LetterGrade{" +
				"grade='" + grade + '\'' +
				", gpaMarkValue='" + gpaMarkValue + '\'' +
				", passFlag='" + passFlag + '\'' +
				", description='" + description + '\'' +
				", label='" + label + '\'' +
				", percentRangeHigh=" + percentRangeHigh +
				", percentRangeLow=" + percentRangeLow +
				", expiryDate=" + expiryDate +
				", effectiveDate=" + effectiveDate +
				'}';
	}
}
