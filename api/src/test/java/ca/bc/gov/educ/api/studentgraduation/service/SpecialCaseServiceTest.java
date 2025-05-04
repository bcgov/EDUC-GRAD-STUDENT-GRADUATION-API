package ca.bc.gov.educ.api.studentgraduation.service;

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

import ca.bc.gov.educ.api.studentgraduation.model.dto.SpecialCase;
import ca.bc.gov.educ.api.studentgraduation.model.entity.SpecialCaseCodeEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.SpecialCaseRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class SpecialCaseServiceTest {

	@Autowired
	private SpecialCaseService specialCaseService;
	
	@MockBean
	private SpecialCaseRepository gradSpecialCaseRepository;
	
	@Autowired
	GradValidation validation;
		
	@Test
	public void testGetAllSpecialCaseList() {
		List<SpecialCaseCodeEntity> gradSpecialCaseList = new ArrayList<>();
		SpecialCaseCodeEntity obj = new SpecialCaseCodeEntity();
		obj.setDescription("D");
		obj.setSpCase("C");
		obj.setPassFlag("Y");
		gradSpecialCaseList.add(obj);
		obj = new SpecialCaseCodeEntity();
		obj.setDescription("G");
		obj.setSpCase("T");
		obj.setPassFlag("N");
		gradSpecialCaseList.add(obj);
		Mockito.when(gradSpecialCaseRepository.findAll()).thenReturn(gradSpecialCaseList);
		assertDoesNotThrow(() -> specialCaseService.getAllSpecialCaseList());
	}
	
	@Test
	public void testGetSpecificSpecialCaseCode() {
		String letterGrade = "D";
		SpecialCase obj = new SpecialCase();
		obj.setDescription("D");
		obj.setSpCase("C");
		obj.setPassFlag("Y");
		SpecialCaseCodeEntity objEntity = new SpecialCaseCodeEntity();
		objEntity.setDescription("D");
		objEntity.setSpCase("C");
		objEntity.setPassFlag("Y");
		Optional<SpecialCaseCodeEntity> ent = Optional.of(objEntity);
		Mockito.when(gradSpecialCaseRepository.findById(letterGrade)).thenReturn(ent);
		specialCaseService.getSpecificSpecialCase(letterGrade);
		Mockito.verify(gradSpecialCaseRepository).findById(letterGrade);
	}
	
	@Test
	public void testGetSpecificSpecialCaseCodeReturnsNull() {
		String letterGrade = "D";
		Mockito.when(gradSpecialCaseRepository.findById(letterGrade)).thenReturn(Optional.empty());
		specialCaseService.getSpecificSpecialCase(letterGrade);
		Mockito.verify(gradSpecialCaseRepository).findById(letterGrade);
	}
}
