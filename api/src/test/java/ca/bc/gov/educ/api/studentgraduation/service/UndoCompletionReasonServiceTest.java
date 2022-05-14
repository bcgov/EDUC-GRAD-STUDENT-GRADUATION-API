package ca.bc.gov.educ.api.studentgraduation.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		ungradReasonService.getAllUndoCompletionReasonCodeList();
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
		ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode);
	}
	
	@Test
	public void testGetSpecificUndoCompletionReasonCodeReturnsNull() {
		String reasonCode = "DC";
		Mockito.when(gradUndoCompletionReasonsRepository.findById(reasonCode)).thenReturn(Optional.empty());
		ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode);
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
		ungradReasonService.createUndoCompletionReason(obj);
		
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
		ungradReasonService.createUndoCompletionReason(obj);
		
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
		ungradReasonService.updateUndoCompletionReason(obj);
		
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
		ungradReasonService.updateUndoCompletionReason(obj);
		
	}	
}