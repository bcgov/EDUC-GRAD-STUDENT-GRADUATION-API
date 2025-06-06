package ca.bc.gov.educ.api.studentgraduation.controller;

import ca.bc.gov.educ.api.studentgraduation.model.dto.*;
import ca.bc.gov.educ.api.studentgraduation.service.AlgorithmRuleService;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import ca.bc.gov.educ.api.studentgraduation.util.MessageHelper;
import ca.bc.gov.educ.api.studentgraduation.util.ResponseHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
class AlgorithmRuleControllerTest {

	@Mock
	private AlgorithmRuleService algorithmRuleService;
	
	@Mock
	ResponseHelper response;
	
	@InjectMocks
	private AlgorithmRuleController algorithmRuleController;
	
	@Mock
	GradValidation validation;
	
	@Mock
	MessageHelper messagesHelper;
	
	@Test
	void testGetAlgorithmRulesList() {
		ProgramAlgorithmRule obj = new ProgramAlgorithmRule();
		AlgorithmRuleCode code = new AlgorithmRuleCode();
		code.setAlgoRuleCode("A");
		obj.setAlgorithmRuleCode(code);
		obj.setProgramAlgoRuleID(UUID.randomUUID());
		Mockito.when(algorithmRuleService.getAlgorithmRulesList("2018-EN")).thenReturn(List.of(obj));
		algorithmRuleController.getAlgorithmRulesList("2018-EN");
		Mockito.verify(algorithmRuleService).getAlgorithmRulesList("2018-EN");
	}

	@Test
	void testGetAllAlgorithmRulesList() {
		ProgramAlgorithmRule obj = new ProgramAlgorithmRule();
		AlgorithmRuleCode code = new AlgorithmRuleCode();
		code.setAlgoRuleCode("A");
		obj.setAlgorithmRuleCode(code);
		obj.setProgramAlgoRuleID(UUID.randomUUID());
		Mockito.when(algorithmRuleService.getAllAlgorithmRulesList()).thenReturn(List.of(obj));
		algorithmRuleController.getAllAlgorithmRulesList();
		Mockito.verify(algorithmRuleService).getAllAlgorithmRulesList();
	}

	@Test
	void testGetAllAlgorithmData() {
		StudentGraduationAlgorithmData data = new StudentGraduationAlgorithmData();
		data.setLetterGrade(new ArrayList<>());
		data.setSpecialCase(new ArrayList<>());
		Mockito.when(algorithmRuleService.getAllAlgorithmData("2018-EN")).thenReturn(data);
		algorithmRuleController.getAllAlgorithmData("2018-EN");
		Mockito.verify(algorithmRuleService).getAllAlgorithmData("2018-EN");
	}

	@Test
	void testGetAllAlgorithmDataList() {
		StudentGraduationAlgorithmData data = new StudentGraduationAlgorithmData();
		data.setLetterGrade(new ArrayList<>());
		data.setSpecialCase(new ArrayList<>());
		Mockito.when(algorithmRuleService.getAllAlgorithmDataList()).thenReturn(List.of(data));
		algorithmRuleController.getAllAlgorithmDataList();
		Mockito.verify(algorithmRuleService).getAllAlgorithmDataList();
	}
}
