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

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.service.StudentUndoCompletionReasonService;
import ca.bc.gov.educ.api.studentgraduation.service.UndoCompletionReasonService;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import ca.bc.gov.educ.api.studentgraduation.util.ResponseHelper;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class UndoCompletionReasonControllerTest {

    @Mock
    private StudentUndoCompletionReasonService studentUndoCompletionReasonService;
    
    @Mock
	private UndoCompletionReasonService ungradReasonService;    

    @Mock
    ResponseHelper responseHelper;

    @Mock
    GradValidation validation;

    @InjectMocks
    private UndoCompletionReasonController ungradReasonController;

    @Test
	void testGetAllUndoCompletionReasonCodeList() {
		List<UndoCompletionReason> gradUndoCompletionReasonList = new ArrayList<>();
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUndoCompletionReasonList.add(obj);
		obj = new UndoCompletionReason();
		obj.setCode("CC");
		obj.setDescription("Courses not complete");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradUndoCompletionReasonList.add(obj);
		Mockito.when(ungradReasonService.getAllUndoCompletionReasonCodeList()).thenReturn(gradUndoCompletionReasonList);
		ungradReasonController.getAllUndoCompletionReasonCodeList();
		Mockito.verify(ungradReasonService).getAllUndoCompletionReasonCodeList();
	}
	
	@Test
	void testGetSpecificUndoCompletionReasonCode() {
		String reasonCode = "DC";
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode)).thenReturn(obj);
		ungradReasonController.getSpecificUndoCompletionReasonCode(reasonCode);
		Mockito.verify(ungradReasonService).getSpecificUndoCompletionReasonCode(reasonCode);
	}
	
	@Test
	void testGetSpecificUndoCompletionReasonCode_noContent() {
		String reasonCode = "AB";	
		Mockito.when(ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode)).thenReturn(null);
		ungradReasonController.getSpecificUndoCompletionReasonCode(reasonCode);
		Mockito.verify(ungradReasonService).getSpecificUndoCompletionReasonCode(reasonCode);
	}
	

    @Test
    void testGetAllStudentUndoCompletionReasonsList() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UndoCompletionReason gradUndoCompletionReason = new UndoCompletionReason();
        gradUndoCompletionReason.setCode("TEST");
        gradUndoCompletionReason.setDescription("Test Code Name");

        // Student Ungrad Reasons Data
        final List<StudentUndoCompletionReason> gradStudentUndoCompletionReasonsList = new ArrayList<>();
        final StudentUndoCompletionReason studentUndoCompletionReason1 = new StudentUndoCompletionReason();
        studentUndoCompletionReason1.setStudentUndoCompletionReasonID(UUID.randomUUID());
        studentUndoCompletionReason1.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason1.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        gradStudentUndoCompletionReasonsList.add(studentUndoCompletionReason1);

        final StudentUndoCompletionReason studentUndoCompletionReason2 = new StudentUndoCompletionReason();
        studentUndoCompletionReason2.setStudentUndoCompletionReasonID(UUID.randomUUID());
        studentUndoCompletionReason2.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason2.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        gradStudentUndoCompletionReasonsList.add(studentUndoCompletionReason2);
        
        Mockito.when(studentUndoCompletionReasonService.getAllStudentUndoCompletionReasonsList(studentID)).thenReturn(gradStudentUndoCompletionReasonsList);
        ungradReasonController.getAllStudentUndoCompletionReasonsList(studentID.toString());
        Mockito.verify(studentUndoCompletionReasonService).getAllStudentUndoCompletionReasonsList(studentID);

    }

    @Test
    void testCreateGradStudentUndoCompletionReason() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UndoCompletionReason gradUndoCompletionReason = new UndoCompletionReason();
        gradUndoCompletionReason.setCode("TEST");
        gradUndoCompletionReason.setDescription("Test Code Name");

        // Student Ungrad Reasons
        final StudentUndoCompletionReason studentUndoCompletionReason = new StudentUndoCompletionReason();
        studentUndoCompletionReason.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());

        Mockito.when(studentUndoCompletionReasonService.createStudentUndoCompletionReason(studentUndoCompletionReason)).thenReturn(studentUndoCompletionReason);
        ungradReasonController.createGradStudentUndoCompletionReason(studentID.toString(), studentUndoCompletionReason);
        Mockito.verify(studentUndoCompletionReasonService).createStudentUndoCompletionReason(studentUndoCompletionReason);
    }
    
    @Test
	void testCreateUndoCompletionReason() {
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(ungradReasonService.createUndoCompletionReason(obj)).thenReturn(obj);
		ungradReasonController.createUndoCompletionReason(obj);
		Mockito.verify(ungradReasonService).createUndoCompletionReason(obj);
	}
	
	@Test
	void testUpdateUndoCompletionReason() {
		UndoCompletionReason obj = new UndoCompletionReason();
		obj.setCode("DC");
		obj.setDescription("Data Correction by School");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		Mockito.when(ungradReasonService.updateUndoCompletionReason(obj)).thenReturn(obj);
		ungradReasonController.updateUndoCompletionReason(obj);
		Mockito.verify(ungradReasonService).updateUndoCompletionReason(obj);
	}
	
	@Test
	void testDeleteUndoCompletionReason() {
		String statusCode = "DC";
		Mockito.when(ungradReasonService.deleteUndoCompletionReason(statusCode)).thenReturn(1);
		ungradReasonController.deleteUndoCompletionReason(statusCode);
		Mockito.verify(ungradReasonService).deleteUndoCompletionReason(statusCode);
	}
}