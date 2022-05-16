package ca.bc.gov.educ.api.studentgraduation.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUndoCompletionReasonEntity;

@Repository
public interface StudentUndoCompletionReasonRepository extends JpaRepository<StudentUndoCompletionReasonEntity, UUID> {

	@Query("select c from StudentUndoCompletionReasonEntity c where c.undoCompletionReasonCode=:reasonCode")
	List<StudentUndoCompletionReasonEntity> existsByUndoCompletionReasonCode(String reasonCode);

	List<StudentUndoCompletionReasonEntity> findByGraduationStudentRecordID(UUID studentID);
}
