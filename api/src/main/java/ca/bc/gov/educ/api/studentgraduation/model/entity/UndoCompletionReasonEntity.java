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
@Table(name = "UNDO_COMPLETION_REASON_CODE")
public class UndoCompletionReasonEntity extends BaseEntity {
   
	@Id
	@Column(name = "UNDO_COMPLETION_REASON_CODE", nullable = false)
    private String code; 
	
	@Column(name = "DESCRIPTION", nullable = true)
    private String description;
	
	@Column(name = "LABEL", nullable = true)
    private String label;
	
	@Column(name = "DISPLAY_ORDER", nullable = true)
    private String displayOrder;
	
	@Column(name = "EFFECTIVE_DATE", nullable = true)
    private String effectiveDate;
	
	@Column(name = "EXPIRY_DATE", nullable = true)
    private String expiryDate;
	
}