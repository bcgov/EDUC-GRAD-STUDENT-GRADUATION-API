package ca.bc.gov.educ.api.studentgraduation.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.dto.SpecialCase;
import ca.bc.gov.educ.api.studentgraduation.service.LetterGradeService;
import ca.bc.gov.educ.api.studentgraduation.service.SpecialCaseService;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import ca.bc.gov.educ.api.studentgraduation.util.MessageHelper;
import ca.bc.gov.educ.api.studentgraduation.util.ResponseHelper;


@ExtendWith(MockitoExtension.class)
public class LettergradeSpecialcaseControllerTest {

	@Mock
	private LetterGradeService letterGradeService;
	
	@Mock
	private SpecialCaseService specialCaseService;
	
	@Mock
	ResponseHelper response;
	
	@InjectMocks
	private LettergradeSpecialcaseController lettergradeSpecialcaseController;
	
	@Mock
	GradValidation validation;
	
	@Mock
	MessageHelper messagesHelper;
	
	@Test
	public void testGetAllLetterGrade() {
		List<LetterGrade> gradList = new ArrayList<>();
		LetterGrade obj = new LetterGrade();
		obj.setGrade("A");
		obj.setPassFlag("Y");
		gradList.add(obj);
		obj = new LetterGrade();
		obj.setGrade("B");
		obj.setPassFlag("Y");
		gradList.add(obj);
		
		Mockito.when(letterGradeService.getAllLetterGradesList()).thenReturn(gradList);
		lettergradeSpecialcaseController.getAllLetterGrades();
		Mockito.verify(letterGradeService).getAllLetterGradesList();
	}
	
	@Test
	public void testGetAllSpecialCase() {
		List<SpecialCase> gradList = new ArrayList<>();
		SpecialCase obj = new SpecialCase();
		obj.setSpCase("A");
		obj.setPassFlag("Y");
		gradList.add(obj);
		obj = new SpecialCase();
		obj.setSpCase("B");
		obj.setPassFlag("Y");
		gradList.add(obj);
		
		Mockito.when(specialCaseService.getAllSpecialCaseList()).thenReturn(gradList);
		lettergradeSpecialcaseController.getAllSpecialCases();
		Mockito.verify(specialCaseService).getAllSpecialCaseList();
	}
	
	@Test
	public void testGetSpecificSpecialCase() {
		String specialCase="A";
		SpecialCase obj = new SpecialCase();
		obj.setSpCase("A");
		obj.setPassFlag("Y");
		Mockito.when(specialCaseService.getSpecificSpecialCase(specialCase)).thenReturn(obj);
		lettergradeSpecialcaseController.getSpecificSpecialCases(specialCase);
		Mockito.verify(specialCaseService).getSpecificSpecialCase(specialCase);
	}
	
	@Test
	public void testGetSpecificLetterGrade() {
		String letterGrade="AB";
		LetterGrade obj = new LetterGrade();
		obj.setGrade("AB");
		obj.setPassFlag("Y");
		Mockito.when(letterGradeService.getSpecificLetterGrade(letterGrade)).thenReturn(obj);
		lettergradeSpecialcaseController.getSpecificLetterGrade(letterGrade);
		Mockito.verify(letterGradeService).getSpecificLetterGrade(letterGrade);
	}
}
