package ca.bc.gov.educ.api.studentgraduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.LetterGradeEntity;

@Repository
public interface LetterGradeRepository extends JpaRepository<LetterGradeEntity, String> {

    List<LetterGradeEntity> findAll();

}
