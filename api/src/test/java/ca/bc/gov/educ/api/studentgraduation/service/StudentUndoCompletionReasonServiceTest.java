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

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.entity.StudentUndoCompletionReasonEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.StudentUndoCompletionReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradBusinessRuleException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class StudentUndoCompletionReasonServiceTest {

    @Autowired
    private StudentUndoCompletionReasonService studentUndoCompletionReasonService;
    
    @MockBean
    private UndoCompletionReasonService ungradReasonService;

    @MockBean
    private StudentUndoCompletionReasonRepository gradStudentUndoCompletionReasonsRepository;


    @Test
    public void testGetAllStudentUndoCompletionReasonsList() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UndoCompletionReason gradUndoCompletionReason = new UndoCompletionReason();
        gradUndoCompletionReason.setCode("TEST");
        gradUndoCompletionReason.setDescription("Test Code Name");

        // Student Ungrad Reasons Data
        final List<StudentUndoCompletionReasonEntity> gradStudentUndoCompletionReasonsList = new ArrayList<>();
        final StudentUndoCompletionReasonEntity studentUndoCompletionReason1 = new StudentUndoCompletionReasonEntity();
        studentUndoCompletionReason1.setStudentUndoCompletionReasonID(UUID.randomUUID());
        studentUndoCompletionReason1.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason1.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        gradStudentUndoCompletionReasonsList.add(studentUndoCompletionReason1);

        final StudentUndoCompletionReasonEntity studentUndoCompletionReason2 = new StudentUndoCompletionReasonEntity();
        studentUndoCompletionReason2.setStudentUndoCompletionReasonID(UUID.randomUUID());
        studentUndoCompletionReason2.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason2.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        gradStudentUndoCompletionReasonsList.add(studentUndoCompletionReason2);

        when(gradStudentUndoCompletionReasonsRepository.findByGraduationStudentRecordID(studentID)).thenReturn(gradStudentUndoCompletionReasonsList);
        var result = studentUndoCompletionReasonService.getAllStudentUndoCompletionReasonsList(studentID);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getGraduationStudentRecordID()).isEqualTo(studentID);
        assertThat(result.get(0).getUndoCompletionReasonCode()).isEqualTo(gradUndoCompletionReason.getCode());
        assertThat(result.get(1).getGraduationStudentRecordID()).isEqualTo(studentID);
        assertThat(result.get(1).getUndoCompletionReasonCode()).isEqualTo(gradUndoCompletionReason.getCode());
    }

    @Test
    public void testCreateGradStudentUndoCompletionReason() {
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
        studentUndoCompletionReason.setUndoCompletionReasonDescription("asdasdad");
        
        final StudentUndoCompletionReasonEntity studentUndoCompletionReasonE = new StudentUndoCompletionReasonEntity();
        studentUndoCompletionReasonE.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReasonE.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        studentUndoCompletionReasonE.setUndoCompletionReasonDescription("asdasdad");

        // Student Ungrad Reasons Entity
        StudentUndoCompletionReasonEntity studentUndoCompletionReasonEntity = new StudentUndoCompletionReasonEntity();
        studentUndoCompletionReasonEntity.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReasonEntity.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        studentUndoCompletionReasonEntity.setStudentUndoCompletionReasonID(new UUID(1, 1));
        studentUndoCompletionReasonEntity.setUndoCompletionReasonDescription("asdasdad");
        when(ungradReasonService.getSpecificUndoCompletionReasonCode(gradUndoCompletionReason.getCode())).thenReturn(gradUndoCompletionReason);
        when(gradStudentUndoCompletionReasonsRepository.save(studentUndoCompletionReasonE)).thenReturn(studentUndoCompletionReasonEntity);
        var result = studentUndoCompletionReasonService.createStudentUndoCompletionReason(studentUndoCompletionReason);

        assertThat(result).isNotNull();
    }

    @Test
    public void testCreateGradStudentUndoCompletionReasonWithExistingEntity_thenReturnBusinessException() {
        // UUID
        final UUID ungradReasonID = UUID.randomUUID();
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UndoCompletionReason gradUndoCompletionReason = new UndoCompletionReason();
        gradUndoCompletionReason.setCode("TEST");
        gradUndoCompletionReason.setDescription("Test Code Name");

        // Student Ungrad Reasons
        final  StudentUndoCompletionReason studentUndoCompletionReason = new StudentUndoCompletionReason();
        studentUndoCompletionReason.setStudentUndoCompletionReasonID(ungradReasonID);
        studentUndoCompletionReason.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());

        // Student Ungrad Reasons Entity
        final StudentUndoCompletionReasonEntity studentUndoCompletionReasonEntity = new StudentUndoCompletionReasonEntity();
        studentUndoCompletionReasonEntity.setStudentUndoCompletionReasonID(ungradReasonID);
        studentUndoCompletionReasonEntity.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReasonEntity.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());

        final Optional<StudentUndoCompletionReasonEntity> optional = Optional.of(studentUndoCompletionReasonEntity);

        when(this.gradStudentUndoCompletionReasonsRepository.findById(ungradReasonID)).thenReturn(optional);

        try {
            var result = studentUndoCompletionReasonService.createStudentUndoCompletionReason(studentUndoCompletionReason);
            Assertions.fail("Business Exception should have been thrown!");
        } catch (GradBusinessRuleException gbre) {
            assertThat(gbre.getMessage()).isNotNull();
        }
    }

    @Test
    public void testGetStudentUndoCompletionReasons() {
        // UUID
        final UUID studentID = UUID.randomUUID();
        // Ungrad Reasons
        final UndoCompletionReason gradUndoCompletionReason = new UndoCompletionReason();
        gradUndoCompletionReason.setCode("TEST");
        gradUndoCompletionReason.setDescription("Test Code Name");

        // Student Ungrad Reasons Data
        final List<StudentUndoCompletionReasonEntity> gradStudentUndoCompletionReasonsList = new ArrayList<>();
        final StudentUndoCompletionReasonEntity studentUndoCompletionReason = new StudentUndoCompletionReasonEntity();
        studentUndoCompletionReason.setStudentUndoCompletionReasonID(UUID.randomUUID());
        studentUndoCompletionReason.setGraduationStudentRecordID(studentID);
        studentUndoCompletionReason.setUndoCompletionReasonCode(gradUndoCompletionReason.getCode());
        gradStudentUndoCompletionReasonsList.add(studentUndoCompletionReason);

        when(gradStudentUndoCompletionReasonsRepository.existsByUndoCompletionReasonCode(gradUndoCompletionReason.getCode())).thenReturn(gradStudentUndoCompletionReasonsList);
        var result = studentUndoCompletionReasonService.getStudentUndoCompletionReasons(gradUndoCompletionReason.getCode());
        assertThat(result).isTrue();

    }
}
