package ca.bc.gov.educ.api.studentgraduation.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ca.bc.gov.educ.api.studentgraduation.model.entity.ProgramAlgorithmRuleEntity;

@Repository
public interface ProgramAlgorithmRuleRepository extends JpaRepository<ProgramAlgorithmRuleEntity, UUID> {
   	
 	@Query("select p from ProgramAlgorithmRuleEntity p inner join AlgorithmRuleCodeEntity c on p.algorithmRuleCode.algoRuleCode = c.algoRuleCode where p.graduationProgramCode=:programCode and c.isActiveRule='Y'")
	List<ProgramAlgorithmRuleEntity> getAlgorithmRulesByProgramCode(String programCode);
}
