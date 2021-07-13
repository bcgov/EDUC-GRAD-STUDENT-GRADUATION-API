package ca.bc.gov.educ.api.studentgraduation.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUngradReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.StudentUngradReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradBusinessRuleException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentUngradReasonServiceTest {

    @Autowired
    private StudentUngradReasonService studentUngradReasonService;
    
    @MockBean
    private UngradReasonService ungradReasonService;

    @MockBean
    private StudentUngradReasonRepository gradStudentUngradReasonsRepository;


    @Test
    public void testGetAllStudentUngradReasonsList() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UngradReason gradUngradReason = new UngradReason();
        gradUngradReason.setCode("TEST");
        gradUngradReason.setDescription("Test Code Name");

        // Student Ungrad Reasons Data
        final List<StudentUngradReasonEntity> gradStudentUngradReasonsList = new ArrayList<>();
        final StudentUngradReasonEntity studentUngradReason1 = new StudentUngradReasonEntity();
        studentUngradReason1.setStudentUngradReasonID(UUID.randomUUID());
        studentUngradReason1.setGraduationStudentRecordID(studentID);
        studentUngradReason1.setUngradReasonCode(gradUngradReason.getCode());
        gradStudentUngradReasonsList.add(studentUngradReason1);

        final StudentUngradReasonEntity studentUngradReason2 = new StudentUngradReasonEntity();
        studentUngradReason2.setStudentUngradReasonID(UUID.randomUUID());
        studentUngradReason2.setGraduationStudentRecordID(studentID);
        studentUngradReason2.setUngradReasonCode(gradUngradReason.getCode());
        gradStudentUngradReasonsList.add(studentUngradReason2);

        when(gradStudentUngradReasonsRepository.findByGraduationStudentRecordID(studentID)).thenReturn(gradStudentUngradReasonsList);
        var result = studentUngradReasonService.getAllStudentUngradReasonsList(studentID);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getGraduationStudentRecordID()).isEqualTo(studentID);
        assertThat(result.get(0).getUngradReasonCode()).isEqualTo(gradUngradReason.getCode());
        assertThat(result.get(1).getGraduationStudentRecordID()).isEqualTo(studentID);
        assertThat(result.get(1).getUngradReasonCode()).isEqualTo(gradUngradReason.getCode());
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
        studentUngradReason.setUngradReasonDescription("asdasdad");
        
        final StudentUngradReasonEntity studentUngradReasonE = new StudentUngradReasonEntity();
        studentUngradReasonE.setGraduationStudentRecordID(studentID);
        studentUngradReasonE.setUngradReasonCode(gradUngradReason.getCode());
        studentUngradReasonE.setUngradReasonDescription("asdasdad");

        // Student Ungrad Reasons Entity
        StudentUngradReasonEntity studentUngradReasonEntity = new StudentUngradReasonEntity();
        studentUngradReasonEntity.setGraduationStudentRecordID(studentID);
        studentUngradReasonEntity.setUngradReasonCode(gradUngradReason.getCode());
        studentUngradReasonEntity.setStudentUngradReasonID(new UUID(1, 1));
        studentUngradReasonEntity.setUngradReasonDescription("asdasdad");
        when(ungradReasonService.getSpecificUngradReasonCode(gradUngradReason.getCode())).thenReturn(gradUngradReason);
        when(gradStudentUngradReasonsRepository.save(studentUngradReasonE)).thenReturn(studentUngradReasonEntity);
        var result = studentUngradReasonService.createStudentUngradReason(studentUngradReason);

        assertThat(result).isNotNull();
    }

    @Test
    public void testCreateGradStudentUngradReasonWithExistingEntity_thenReturnBusinessException() {
        // UUID
        final UUID ungradReasonID = UUID.randomUUID();
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UngradReason gradUngradReason = new UngradReason();
        gradUngradReason.setCode("TEST");
        gradUngradReason.setDescription("Test Code Name");

        // Student Ungrad Reasons
        final  StudentUngradReason studentUngradReason = new StudentUngradReason();
        studentUngradReason.setStudentUngradReasonID(ungradReasonID);
        studentUngradReason.setGraduationStudentRecordID(studentID);
        studentUngradReason.setUngradReasonCode(gradUngradReason.getCode());

        // Student Ungrad Reasons Entity
        final StudentUngradReasonEntity studentUngradReasonEntity = new StudentUngradReasonEntity();
        studentUngradReasonEntity.setStudentUngradReasonID(ungradReasonID);
        studentUngradReasonEntity.setGraduationStudentRecordID(studentID);
        studentUngradReasonEntity.setUngradReasonCode(gradUngradReason.getCode());

        final Optional<StudentUngradReasonEntity> optional = Optional.of(studentUngradReasonEntity);

        when(this.gradStudentUngradReasonsRepository.findById(ungradReasonID)).thenReturn(optional);

        try {
            var result = studentUngradReasonService.createStudentUngradReason(studentUngradReason);
            Assertions.fail("Business Exception should have been thrown!");
        } catch (GradBusinessRuleException gbre) {
            assertThat(gbre.getMessage()).isNotNull();
        }
    }

    @Test
    public void testGetStudentUngradReasons() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UngradReason gradUngradReason = new UngradReason();
        gradUngradReason.setCode("TEST");
        gradUngradReason.setDescription("Test Code Name");

        // Student Ungrad Reasons Data
        final List<StudentUngradReasonEntity> gradStudentUngradReasonsList = new ArrayList<>();
        final StudentUngradReasonEntity studentUngradReason = new StudentUngradReasonEntity();
        studentUngradReason.setStudentUngradReasonID(UUID.randomUUID());
        studentUngradReason.setGraduationStudentRecordID(studentID);
        studentUngradReason.setUngradReasonCode(gradUngradReason.getCode());
        gradStudentUngradReasonsList.add(studentUngradReason);

        when(gradStudentUngradReasonsRepository.existsByUngradReasonCode(gradUngradReason.getCode())).thenReturn(gradStudentUngradReasonsList);
        var result = studentUngradReasonService.getStudentUngradReasons(gradUngradReason.getCode());
        assertThat(result).isTrue();

    }
}
