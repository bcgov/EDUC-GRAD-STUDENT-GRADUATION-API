package ca.bc.gov.educ.api.studentgraduation.model.entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PROGRAM_ALGORITHM_RULE")
public class ProgramAlgorithmRuleEntity extends BaseEntity {
   
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "PROGRAM_ALGO_RULE_ID", nullable = false)
    private UUID programAlgoRuleID; 
	
	@Column(name = "GRADUATION_PROGRAM_CODE", nullable = false)
    private String graduationProgramCode;
	
	@Column(name = "SORT_ORDER", nullable = false)
    private Integer sortOrder;	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALGORITHM_RULE_CODE", referencedColumnName = "ALGORITHM_RULE_CODE")
    private AlgorithmRuleCodeEntity algorithmRuleCode;
	
}