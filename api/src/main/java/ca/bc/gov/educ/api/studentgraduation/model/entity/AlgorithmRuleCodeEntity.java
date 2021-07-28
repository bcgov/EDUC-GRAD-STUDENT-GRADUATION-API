package ca.bc.gov.educ.api.studentgraduation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ALGORITHM_RULE_CODE")
public class AlgorithmRuleCodeEntity extends BaseEntity {
   
	@Id
	@Column(name = "ALGORITHM_RULE_CODE", nullable = false)
    private String algoRuleCode; 
	
	@Column(name = "RULE_IMPL_NAME", nullable = false)
    private String ruleImplementation; 
	
	@Column(name = "LABEL", nullable = false)
    private String label; 
	
	@Column(name = "DESCRIPTION", nullable = false)
    private String description;
	
	@Column(name = "DISPLAY_ORDER", nullable = false)
    private Integer displayOrder;
	
	@Column(name = "ACTIVE_RULE", nullable = false)
    private String isActiveRule;
}