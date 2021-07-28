package ca.bc.gov.educ.api.studentgraduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.UngradReasonEntity;

@Repository
public interface UngradReasonRepository extends JpaRepository<UngradReasonEntity, String> {

    List<UngradReasonEntity> findAll();

}
