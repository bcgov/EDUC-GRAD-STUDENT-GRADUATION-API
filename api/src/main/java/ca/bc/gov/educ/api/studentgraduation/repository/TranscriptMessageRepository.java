package ca.bc.gov.educ.api.studentgraduation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.TranscriptMessageEntity;

@Repository
public interface TranscriptMessageRepository extends JpaRepository<TranscriptMessageEntity, String> {

    List<TranscriptMessageEntity> findAll();

	Optional<TranscriptMessageEntity> findByGraduationProgramCodeAndMessageTypeCode(String pgmCode, String msgType);

}
