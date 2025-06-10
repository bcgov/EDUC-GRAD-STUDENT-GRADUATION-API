package ca.bc.gov.educ.api.studentgraduation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.entity.LetterGradeEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.LetterGradeRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class LetterGradeServiceTest {

	@Autowired
	private LetterGradeService letterGradeService;
	
	@MockBean
	private LetterGradeRepository letterGradeRepository;
	
	@Autowired
	GradValidation validation;

	@MockBean
	@Qualifier("studentGraduationApiClient")
	WebClient studentGraduationApiClient;
	
	@Test
	public void testGetAllLetterGradeList() {
		List<LetterGradeEntity> gradLettergradeList = new ArrayList<>();
		LetterGradeEntity obj = new LetterGradeEntity();
		obj.setGpaMarkValue("2.5");
		obj.setGrade("C");
		obj.setPassFlag("Y");
		gradLettergradeList.add(obj);
		obj.setGpaMarkValue("1.5");
		obj.setGrade("D");
		obj.setPassFlag("N");
		gradLettergradeList.add(obj);
		Mockito.when(letterGradeRepository.findAll()).thenReturn(gradLettergradeList);
		letterGradeService.getAllLetterGradesList();
	}
	
	@Test
	public void testGetSpecificLetterGradeCode() {
		String letterGrade = "C";
		LetterGrade obj = new LetterGrade();
		obj.setGpaMarkValue("2.5");
		obj.setGrade("C");
		obj.setPassFlag("Y");
		LetterGradeEntity objEntity = new LetterGradeEntity();
		objEntity.setGpaMarkValue("2.5");
		objEntity.setGrade("C");
		objEntity.setPassFlag("Y");
		Optional<LetterGradeEntity> ent = Optional.of(objEntity);
		Mockito.when(letterGradeRepository.findById(letterGrade)).thenReturn(ent);
		letterGradeService.getSpecificLetterGrade(letterGrade);
		Mockito.verify(letterGradeRepository).findById(letterGrade);
	}
	
	@Test
	public void testGetSpecificLetterGradeCodeReturnsNull() {
		String letterGrade = "C";
		Mockito.when(letterGradeRepository.findById(letterGrade)).thenReturn(Optional.empty());
		letterGradeService.getSpecificLetterGrade(letterGrade);
		Mockito.verify(letterGradeRepository).findById(letterGrade);
	}
	
}
