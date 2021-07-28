package ca.bc.gov.educ.api.studentgraduation.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.service.StudentUngradReasonService;
import ca.bc.gov.educ.api.studentgraduation.service.UngradReasonService;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import ca.bc.gov.educ.api.studentgraduation.util.ResponseHelper;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class UngradReasonControllerTest {

    @Mock
    private StudentUngradReasonService studentUngradReasonService;
    
    @Mock
	private UngradReasonService ungradReasonService;    

    @Mock
    ResponseHelper responseHelper;

    @Mock
    GradValidation validation;

    @InjectMocks
    private UngradReasonController ungradReasonController;

    @Test
	public void testGetAllUngradReasonCodeList() {
		List<UngradReason> gradUngradReasonList = new ArrayList<>();
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUngradReasonList.add(obj);
		obj = new UngradReason();
		obj.setCode("CC");
		obj.setDescription("Courses not complete");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUngradReasonList.add(obj);
		Mockito.when(ungradReasonService.getAllUngradReasonCodeList()).thenReturn(gradUngradReasonList);
		ungradReasonController.getAllUngradReasonCodeList();
		Mockito.verify(ungradReasonService).getAllUngradReasonCodeList();
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
		Mockito.when(ungradReasonService.getSpecificUngradReasonCode(reasonCode)).thenReturn(obj);
		ungradReasonController.getSpecificUngradReasonCode(reasonCode);
		Mockito.verify(ungradReasonService).getSpecificUngradReasonCode(reasonCode);
	}
	
	@Test
	public void testGetSpecificUngradReasonCode_noContent() {
		String reasonCode = "AB";	
		Mockito.when(ungradReasonService.getSpecificUngradReasonCode(reasonCode)).thenReturn(null);
		ungradReasonController.getSpecificUngradReasonCode(reasonCode);
		Mockito.verify(ungradReasonService).getSpecificUngradReasonCode(reasonCode);
	}
	

    @Test
    public void testGetAllStudentUngradReasonsList() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UngradReason gradUngradReason = new UngradReason();
        gradUngradReason.setCode("TEST");
        gradUngradReason.setDescription("Test Code Name");

        // Student Ungrad Reasons Data
        final List<StudentUngradReason> gradStudentUngradReasonsList = new ArrayList<>();
        final StudentUngradReason studentUngradReason1 = new StudentUngradReason();
        studentUngradReason1.setStudentUngradReasonID(UUID.randomUUID());
        studentUngradReason1.setGraduationStudentRecordID(studentID);
        studentUngradReason1.setUngradReasonCode(gradUngradReason.getCode());
        gradStudentUngradReasonsList.add(studentUngradReason1);

        final StudentUngradReason studentUngradReason2 = new StudentUngradReason();
        studentUngradReason2.setStudentUngradReasonID(UUID.randomUUID());
        studentUngradReason2.setGraduationStudentRecordID(studentID);
        studentUngradReason2.setUngradReasonCode(gradUngradReason.getCode());
        gradStudentUngradReasonsList.add(studentUngradReason2);
        
        Mockito.when(studentUngradReasonService.getAllStudentUngradReasonsList(studentID)).thenReturn(gradStudentUngradReasonsList);
        ungradReasonController.getAllStudentUngradReasonsList(studentID.toString());
        Mockito.verify(studentUngradReasonService).getAllStudentUngradReasonsList(studentID);

    }

    @Test
    public void testCreateGradStudentUngradReason() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UngradReason gradUngradReason = new UngradReason();
        gradUngradReason.setCode("TEST");
        gradUngradReason.setDescription("Test Code Name");

        // Student Ungrad Reasons
        final StudentUngradReason studentUngradReason = new StudentUngradReason();
        studentUngradReason.setGraduationStudentRecordID(studentID);
        studentUngradReason.setUngradReasonCode(gradUngradReason.getCode());

        Mockito.when(studentUngradReasonService.createStudentUngradReason(studentUngradReason)).thenReturn(studentUngradReason);
        ungradReasonController.createGradStudentUngradReason(studentID.toString(), studentUngradReason);
        Mockito.verify(studentUngradReasonService).createStudentUngradReason(studentUngradReason);
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
		Mockito.when(ungradReasonService.createUngradReason(obj)).thenReturn(obj);
		ungradReasonController.createUngradReason(obj);
		Mockito.verify(ungradReasonService).createUngradReason(obj);
	}
	
	@Test
	public void testUpdateUngradReason() {
		UngradReason obj = new UngradReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(ungradReasonService.updateUngradReason(obj)).thenReturn(obj);
		ungradReasonController.updateUngradReason(obj);
		Mockito.verify(ungradReasonService).updateUngradReason(obj);
	}
	
	@Test
	public void testDeleteUngradReason() {
		String statusCode = "DC";
		Mockito.when(ungradReasonService.deleteUngradReason(statusCode)).thenReturn(1);
		ungradReasonController.deleteUngradReason(statusCode);
		Mockito.verify(ungradReasonService).deleteUngradReason(statusCode);
	}
}