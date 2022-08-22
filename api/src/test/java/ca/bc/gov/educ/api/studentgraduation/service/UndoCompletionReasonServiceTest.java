package ca.bc.gov.educ.api.studentgraduation.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUndoCompletionReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.StudentUndoCompletionReasonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.UndoCompletionReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.TranscriptMessageRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.UndoCompletionReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradBusinessRuleException;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UndoCompletionReasonServiceTest {
	
	@Autowired
	private UndoCompletionReasonService ungradReasonService;
	
	@MockBean
	private UndoCompletionReasonRepository gradUndoCompletionReasonsRepository;

	@MockBean
	private TranscriptMessageRepository gradMessagingRepository;

	@MockBean
	private StudentUndoCompletionReasonRepository studentUndoCompletionReasonRepository;

	@Autowired
	GradValidation validation;
	
	
	@Test
	public void testGetAllUndoCompletionReasonCodeList() {
		List<UndoCompletionReasonEntity> gradUndoCompletionReasonList = new ArrayList<>();
		UndoCompletionReasonEntity obj = new UndoCompletionReasonEntity();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUndoCompletionReasonList.add(obj);
		obj = new UndoCompletionReasonEntity();
		obj.setCode("CC");
		obj.setDescription("Courses not complete");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUndoCompletionReasonList.add(obj);
		Mockito.when(gradUndoCompletionReasonsRepository.findAll()).thenReturn(gradUndoCompletionReasonList);
		List<UndoCompletionReason> resList = ungradReasonService.getAllUndoCompletionReasonCodeList();
		assertThat(resList).hasSize(2);
	}
	
	@Test
	public void testGetSpecificUndoCompletionReasonCode() {
		String reasonCode = "DC";
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		obj.toString();
		UndoCompletionReasonEntity objEntity = new UndoCompletionReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<UndoCompletionReasonEntity> ent = Optional.of(objEntity);
		Mockito.when(gradUndoCompletionReasonsRepository.findById(reasonCode)).thenReturn(ent);
		UndoCompletionReason res = ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode);
		assertThat(res.getCode()).isEqualTo(obj.getCode());
	}
	
	@Test
	public void testGetSpecificUndoCompletionReasonCodeReturnsNull() {
		String reasonCode = "DC";
		Mockito.when(gradUndoCompletionReasonsRepository.findById(reasonCode)).thenReturn(Optional.empty());
		UndoCompletionReason res = ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode);
		assertThat(res).isNull();
	}
	
	
	@Test
	public void testCreateUndoCompletionReason() {
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UndoCompletionReasonEntity objEntity = new UndoCompletionReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(gradUndoCompletionReasonsRepository.findById(obj.getCode())).thenReturn(Optional.empty());
		Mockito.when(gradUndoCompletionReasonsRepository.save(objEntity)).thenReturn(objEntity);
		UndoCompletionReason res = ungradReasonService.createUndoCompletionReason(obj);
		assertThat(res).isNotNull();
		assertThat(res.getCode()).isEqualTo(obj.getCode());
		
	}
	
	@Test(expected = GradBusinessRuleException.class)
	public void testCreateUndoCompletionReason_codeAlreadyExists() {
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UndoCompletionReasonEntity objEntity = new UndoCompletionReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<UndoCompletionReasonEntity> ent = Optional.of(objEntity);
		Mockito.when(gradUndoCompletionReasonsRepository.findById(obj.getCode())).thenReturn(ent);
		UndoCompletionReason res = ungradReasonService.createUndoCompletionReason(obj);
		assertThat(res).isNotNull();
		
	}
	
	@Test
	public void testUpdateUndoCompletionReason() {
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by Schools");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UndoCompletionReasonEntity objEntity = new UndoCompletionReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<UndoCompletionReasonEntity> ent = Optional.of(objEntity);
		Mockito.when(gradUndoCompletionReasonsRepository.findById(obj.getCode())).thenReturn(ent);
		Mockito.when(gradUndoCompletionReasonsRepository.save(objEntity)).thenReturn(objEntity);
		UndoCompletionReason res = ungradReasonService.updateUndoCompletionReason(obj);
		assertThat(res).isNotNull();
	}
	
	@Test(expected = GradBusinessRuleException.class)
	public void testUpdateUndoCompletionReason_codeAlreadyExists() {
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by Schools");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UndoCompletionReasonEntity objEntity = new UndoCompletionReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(gradUndoCompletionReasonsRepository.findById(obj.getCode())).thenReturn(Optional.empty());
		UndoCompletionReason res = ungradReasonService.updateUndoCompletionReason(obj);
		assertThat(res).isNotNull();
	}

	@Test(expected = GradBusinessRuleException.class)
	public void testDeleteUndoCompletionReason_existing() {
		StudentUndoCompletionReasonEntity ent = new StudentUndoCompletionReasonEntity();
		ent.setStudentUndoCompletionReasonID(UUID.randomUUID());
		ent.setUndoCompletionReasonCode("DC");

		Mockito.when(studentUndoCompletionReasonRepository.existsByUndoCompletionReasonCode("DC")).thenReturn(List.of(ent));
		int count = ungradReasonService.deleteUndoCompletionReason("DC");
		assertThat(count).isZero();
	}

	@Test
	public void testDeleteUndoCompletionReason() {
		Mockito.when(studentUndoCompletionReasonRepository.existsByUndoCompletionReasonCode("DC")).thenReturn(new ArrayList<>());
		int count = ungradReasonService.deleteUndoCompletionReason("DC");
		assertThat(count).isEqualTo(1);
	}
}