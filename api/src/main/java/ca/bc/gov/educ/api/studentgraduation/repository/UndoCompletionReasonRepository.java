package ca.bc.gov.educ.api.studentgraduation.repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.UndoCompletionReasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UndoCompletionReasonRepository extends JpaRepository<UndoCompletionReasonEntity, String> {

    List<UndoCompletionReasonEntity> findAll();

}
