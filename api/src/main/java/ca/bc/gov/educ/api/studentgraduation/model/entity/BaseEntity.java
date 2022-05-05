package ca.bc.gov.educ.api.studentgraduation.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ca.bc.gov.educ.api.studentgraduation.util.ThreadLocalStateUtil;
import org.apache.commons.lang3.StringUtils;

import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
	@Column(name = "CREATE_USER", nullable = true)
    private String createUser;
	
	@Column(name = "CREATE_DATE", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
	
	@Column(name = "UPDATE_USER", nullable = true)
    private String updateUser;
	
	@Column(name = "UPDATE_DATE", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@PrePersist
	protected void onCreate() {
		if (StringUtils.isBlank(createUser)) {
			this.createUser = ThreadLocalStateUtil.getCurrentUser();
			if (StringUtils.isBlank(createUser)) {
				this.createUser = EducGradStudentGraduationApiConstants.DEFAULT_CREATED_BY;
			}
		}
		if (StringUtils.isBlank(updateUser)) {
			this.updateUser = ThreadLocalStateUtil.getCurrentUser();
			if (StringUtils.isBlank(updateUser)) {
				this.updateUser = EducGradStudentGraduationApiConstants.DEFAULT_UPDATED_BY;
			}
		}
		this.createDate = new Date(System.currentTimeMillis());
		this.updateDate = new Date(System.currentTimeMillis());

	}

	@PreUpdate
	protected void onPersist() {
		this.updateDate = new Date(System.currentTimeMillis());
		if (StringUtils.isBlank(updateUser)) {
			this.updateUser = ThreadLocalStateUtil.getCurrentUser();
			if (StringUtils.isBlank(updateUser)) {
				this.updateUser = EducGradStudentGraduationApiConstants.DEFAULT_UPDATED_BY;
			}
		}
		if (StringUtils.isBlank(createUser)) {
			this.createUser = ThreadLocalStateUtil.getCurrentUser();
			if (StringUtils.isBlank(createUser)) {
				this.createUser = EducGradStudentGraduationApiConstants.DEFAULT_CREATED_BY;
			}
		}
		if (this.createDate == null) {
			this.createDate = new Date(System.currentTimeMillis());
		}
	}
}
