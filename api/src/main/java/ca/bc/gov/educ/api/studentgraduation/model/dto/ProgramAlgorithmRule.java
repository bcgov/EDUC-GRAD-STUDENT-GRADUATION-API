package ca.bc.gov.educ.api.studentgraduation.model.dto;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class ProgramAlgorithmRule extends BaseModel {

	private UUID programAlgoRuleID; 
	private String graduationProgramCode;
	private Integer sortOrder;	
	private AlgorithmRuleCode algorithmRuleCode;
}
