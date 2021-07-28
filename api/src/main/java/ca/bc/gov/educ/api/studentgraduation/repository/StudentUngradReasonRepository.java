package ca.bc.gov.educ.api.studentgraduation.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUngradReasonEntity;

@Repository
public interface StudentUngradReasonRepository extends JpaRepository<StudentUngradReasonEntity, UUID> {

	@Query("select c from StudentUngradReasonEntity c where c.ungradReasonCode=:reasonCode")
	List<StudentUngradReasonEntity> existsByUngradReasonCode(String reasonCode);

	List<StudentUngradReasonEntity> findByGraduationStudentRecordID(UUID studentID);
}
