package ca.bc.gov.educ.api.studentgraduation.model.dto;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class AlgorithmRuleCode extends BaseModel {

	private String algoRuleCode; 
	private String ruleImplementation; 
	private String label; 
	private String description;
	private Integer displayOrder;
	private String isActiveRule;
}
