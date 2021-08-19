package ca.bc.gov.educ.api.studentgraduation.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Component
public class LetterGrade extends BaseModel {

	private String grade; 
	private String gpaMarkValue; 
	private String passFlag;
	private String description;
	
	
	@Override
	public String toString() {
		return "LetterGrade [grade=" + grade + ", gpaMarkValue=" + gpaMarkValue + ", passFlag="
				+ passFlag + "]";
	}
	
				
}
