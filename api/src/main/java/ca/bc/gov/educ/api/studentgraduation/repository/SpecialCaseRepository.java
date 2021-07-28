package ca.bc.gov.educ.api.studentgraduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.SpecialCaseCodeEntity;

@Repository
public interface SpecialCaseRepository extends JpaRepository<SpecialCaseCodeEntity, String> {
}
