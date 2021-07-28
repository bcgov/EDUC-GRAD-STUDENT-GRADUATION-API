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

import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.UngradReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.TranscriptMessageRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.UngradReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradBusinessRuleException;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UngradReasonServiceTest {
	
	@Autowired
	private UngradReasonService ungradReasonService;
	
	@MockBean
	private UngradReasonRepository gradUngradReasonsRepository;

	@MockBean
	private TranscriptMessageRepository gradMessagingRepository;

	@Autowired
	GradValidation validation;
	
	
	@Test
	public void testGetAllUngradReasonCodeList() {
		List<UngradReasonEntity> gradUngradReasonList = new ArrayList<>();
		UngradReasonEntity obj = new UngradReasonEntity();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUngradReasonList.add(obj);
		obj = new UngradReasonEntity();
		obj.setCode("CC");
		obj.setDescription("Courses not complete");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUngradReasonList.add(obj);
		Mockito.when(gradUngradReasonsRepository.findAll()).thenReturn(gradUngradReasonList);
		ungradReasonService.getAllUngradReasonCodeList();
	}
	
	@Test
	public void testGetSpecificUngradReasonCode() {
		String reasonCode = "DC";
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		obj.toString();
		UngradReasonEntity objEntity = new UngradReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<UngradReasonEntity> ent = Optional.of(objEntity);
		Mockito.when(gradUngradReasonsRepository.findById(reasonCode)).thenReturn(ent);
		ungradReasonService.getSpecificUngradReasonCode(reasonCode);
	}
	
	@Test
	public void testGetSpecificUngradReasonCodeReturnsNull() {
		String reasonCode = "DC";
		Mockito.when(gradUngradReasonsRepository.findById(reasonCode)).thenReturn(Optional.empty());
		ungradReasonService.getSpecificUngradReasonCode(reasonCode);
	}
	
	
	@Test
	public void testCreateUngradReason() {
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UngradReasonEntity objEntity = new UngradReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(gradUngradReasonsRepository.findById(obj.getCode())).thenReturn(Optional.empty());
		Mockito.when(gradUngradReasonsRepository.save(objEntity)).thenReturn(objEntity);
		ungradReasonService.createUngradReason(obj);
		
	}
	
	@Test(expected = GradBusinessRuleException.class)
	public void testCreateUngradReason_codeAlreadyExists() {
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UngradReasonEntity objEntity = new UngradReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<UngradReasonEntity> ent = Optional.of(objEntity);
		Mockito.when(gradUngradReasonsRepository.findById(obj.getCode())).thenReturn(ent);
		ungradReasonService.createUngradReason(obj);
		
	}
	
	@Test
	public void testUpdateUngradReason() {
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by Schools");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UngradReasonEntity objEntity = new UngradReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<UngradReasonEntity> ent = Optional.of(objEntity);
		Mockito.when(gradUngradReasonsRepository.findById(obj.getCode())).thenReturn(ent);
		Mockito.when(gradUngradReasonsRepository.save(objEntity)).thenReturn(objEntity);
		ungradReasonService.updateUngradReason(obj);
		
	}
	
	@Test(expected = GradBusinessRuleException.class)
	public void testUpdateUngradReason_codeAlreadyExists() {
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by Schools");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		UngradReasonEntity objEntity = new UngradReasonEntity();
		objEntity.setCode("DC");
		objEntity.setDescription("Data Correction by School");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(gradUngradReasonsRepository.findById(obj.getCode())).thenReturn(Optional.empty());
		ungradReasonService.updateUngradReason(obj);
		
	}	
}