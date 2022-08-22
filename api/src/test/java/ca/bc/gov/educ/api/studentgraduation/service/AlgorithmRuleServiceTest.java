package ca.bc.gov.educ.api.studentgraduation.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import ca.bc.gov.educ.api.studentgraduation.model.dto.GraduationProgramCode;
import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentGraduationAlgorithmData;
import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import ca.bc.gov.educ.api.studentgraduation.model.entity.AlgorithmRuleCodeEntity;
import ca.bc.gov.educ.api.studentgraduation.model.entity.LetterGradeEntity;
import ca.bc.gov.educ.api.studentgraduation.model.entity.ProgramAlgorithmRuleEntity;
import ca.bc.gov.educ.api.studentgraduation.model.entity.SpecialCaseCodeEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.LetterGradeRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.ProgramAlgorithmRuleRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.SpecialCaseRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AlgorithmRuleServiceTest {

	@Autowired
	private AlgorithmRuleService algorithmRuleService;
	
	@MockBean
	private ProgramAlgorithmRuleRepository programAlgorithmRuleRepository;
	
	@MockBean
	private LetterGradeRepository letterGradeRepository;
	
	@MockBean
	private SpecialCaseRepository specialCaseRepository;
	
	@Autowired
	GradValidation validation;

    @MockBean
    WebClient webClient;

    @Autowired
    EducGradStudentGraduationApiConstants constants;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersMock;
    @Mock WebClient.RequestHeadersUriSpec requestHeadersUriMock;
    @Mock WebClient.ResponseSpec responseMock;
    @Mock WebClient.RequestBodySpec requestBodyMock;
    @Mock WebClient.RequestBodyUriSpec requestBodyUriMock;

    @BeforeClass
    public static void setup() {

    }

    @After
    public void tearDown() {

    }

    @Before
    public void init() {
        openMocks(this);
    }

    @Test
    public void testGetAllAlgorithmDataList() throws Exception {
        String accessToken = "accessToken";
        GraduationProgramCode code = new GraduationProgramCode();
        code.setProgramCode("2018-EN");
        when(this.webClient.get()).thenReturn(this.requestHeadersUriMock);
        when(this.requestHeadersUriMock.uri(constants.getProgramList())).thenReturn(this.requestHeadersMock);
        when(this.requestHeadersMock.headers(any(Consumer.class))).thenReturn(this.requestHeadersMock);
        when(this.requestHeadersMock.retrieve()).thenReturn(this.responseMock);
        when(this.responseMock.bodyToMono(new ParameterizedTypeReference<List<GraduationProgramCode>>(){})).thenReturn(Mono.just(List.of(code)));

        List<StudentGraduationAlgorithmData> res = algorithmRuleService.getAllAlgorithmDataList(accessToken);
        assertNotNull(res);
        assertThat(res).hasSize(1);
    }

	
	@Test
	public void testGetAlgorithmRulesList() {
		// UUID
        final UUID ID = UUID.randomUUID();
        final String programCode1 = "2018-EN";
        final String programCode2 = "2018-FI";

        // Student Certificate Types
        final List<ProgramAlgorithmRuleEntity> algorithmsRulesList = new ArrayList<>();

        final ProgramAlgorithmRuleEntity gradAlgorithmRule1 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule1.setProgramAlgoRuleID(ID);
        gradAlgorithmRule1.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity = new AlgorithmRuleCodeEntity();
        ruleCodeEntity.setAlgoRuleCode("AB");
        ruleCodeEntity.setRuleImplementation("ABCD");
        ruleCodeEntity.setIsActiveRule("Y");
        gradAlgorithmRule1.setAlgorithmRuleCode(ruleCodeEntity);
        gradAlgorithmRule1.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule1);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule2 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule2.setProgramAlgoRuleID(ID);
        gradAlgorithmRule2.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity2 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity2.setAlgoRuleCode("AB");
        ruleCodeEntity2.setRuleImplementation("ABC");
        ruleCodeEntity2.setIsActiveRule("Y");
        gradAlgorithmRule2.setAlgorithmRuleCode(ruleCodeEntity2);
        gradAlgorithmRule2.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule2);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule3 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule3.setProgramAlgoRuleID(ID);
        gradAlgorithmRule3.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity3 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity3.setAlgoRuleCode("AB");
        ruleCodeEntity3.setRuleImplementation("ABCDE");
        ruleCodeEntity3.setIsActiveRule("Y");
        gradAlgorithmRule3.setAlgorithmRuleCode(ruleCodeEntity3);
        gradAlgorithmRule3.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule3);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule4 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule4.setProgramAlgoRuleID(ID);
        gradAlgorithmRule4.setGraduationProgramCode(programCode2);
        final AlgorithmRuleCodeEntity ruleCodeEntity4 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity4.setAlgoRuleCode("AB");
        ruleCodeEntity4.setRuleImplementation("ABCDEF");
        ruleCodeEntity4.setIsActiveRule("Y");
        gradAlgorithmRule4.setAlgorithmRuleCode(ruleCodeEntity4);
        gradAlgorithmRule4.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule4);

        when(programAlgorithmRuleRepository.findAll()).thenReturn(algorithmsRulesList);

        var result = algorithmRuleService.getAllAlgorithmRulesList();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(4);
        assertThat(result.get(0).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule1.getAlgorithmRuleCode().getRuleImplementation());
        assertThat(result.get(1).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule2.getAlgorithmRuleCode().getRuleImplementation());
        assertThat(result.get(2).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule3.getAlgorithmRuleCode().getRuleImplementation());
        assertThat(result.get(3).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule4.getAlgorithmRuleCode().getRuleImplementation());
	}	
	
	@Test
	public void testGetAlgorithmRulesList_WithProgram() {
		// UUID
        final UUID ID = UUID.randomUUID();
        final String programCode1 = "2018-EN";

        // Student Certificate Types
        final List<ProgramAlgorithmRuleEntity> algorithmsRulesList = new ArrayList<>();

        final ProgramAlgorithmRuleEntity gradAlgorithmRule1 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule1.setProgramAlgoRuleID(ID);
        gradAlgorithmRule1.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity = new AlgorithmRuleCodeEntity();
        ruleCodeEntity.setAlgoRuleCode("AB");
        ruleCodeEntity.setRuleImplementation("ABCD");
        ruleCodeEntity.setIsActiveRule("Y");
        gradAlgorithmRule1.setAlgorithmRuleCode(ruleCodeEntity);
        gradAlgorithmRule1.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule1);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule2 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule2.setProgramAlgoRuleID(ID);
        gradAlgorithmRule2.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity2 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity2.setAlgoRuleCode("AB");
        ruleCodeEntity2.setRuleImplementation("ABC");
        ruleCodeEntity2.setIsActiveRule("Y");
        gradAlgorithmRule2.setAlgorithmRuleCode(ruleCodeEntity2);
        gradAlgorithmRule2.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule2);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule3 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule3.setProgramAlgoRuleID(ID);
        gradAlgorithmRule3.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity3 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity3.setAlgoRuleCode("AB");
        ruleCodeEntity3.setRuleImplementation("ABCDE");
        ruleCodeEntity3.setIsActiveRule("Y");
        gradAlgorithmRule3.setAlgorithmRuleCode(ruleCodeEntity3);
        gradAlgorithmRule3.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule3);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule4 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule4.setProgramAlgoRuleID(ID);
        gradAlgorithmRule4.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity4 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity4.setAlgoRuleCode("AB");
        ruleCodeEntity4.setRuleImplementation("ABCDEF");
        ruleCodeEntity4.setIsActiveRule("Y");
        gradAlgorithmRule4.setAlgorithmRuleCode(ruleCodeEntity4);
        gradAlgorithmRule4.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule4);

        when(programAlgorithmRuleRepository.getAlgorithmRulesByProgramCode(programCode1)).thenReturn(algorithmsRulesList);

        var result = algorithmRuleService.getAlgorithmRulesList(programCode1);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(4);
        assertThat(result.get(0).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule1.getAlgorithmRuleCode().getRuleImplementation());
        assertThat(result.get(1).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule2.getAlgorithmRuleCode().getRuleImplementation());
        assertThat(result.get(2).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule3.getAlgorithmRuleCode().getRuleImplementation());
        assertThat(result.get(3).getAlgorithmRuleCode().getRuleImplementation()).isEqualTo(gradAlgorithmRule4.getAlgorithmRuleCode().getRuleImplementation());
	}
	
	@Test
	public void testGetAllAlgorithmData() {
		// UUID
        final UUID ID = UUID.randomUUID();
        final String programCode1 = "2018-EN";

        // Student Certificate Types
        final List<ProgramAlgorithmRuleEntity> algorithmsRulesList = new ArrayList<>();

        final ProgramAlgorithmRuleEntity gradAlgorithmRule1 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule1.setProgramAlgoRuleID(ID);
        gradAlgorithmRule1.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity = new AlgorithmRuleCodeEntity();
        ruleCodeEntity.setAlgoRuleCode("AB");
        ruleCodeEntity.setRuleImplementation("ABCD");
        ruleCodeEntity.setIsActiveRule("Y");
        gradAlgorithmRule1.setAlgorithmRuleCode(ruleCodeEntity);
        gradAlgorithmRule1.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule1);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule2 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule2.setProgramAlgoRuleID(ID);
        gradAlgorithmRule2.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity2 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity2.setAlgoRuleCode("AB");
        ruleCodeEntity2.setRuleImplementation("ABC");
        ruleCodeEntity2.setIsActiveRule("Y");
        gradAlgorithmRule2.setAlgorithmRuleCode(ruleCodeEntity2);
        gradAlgorithmRule2.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule2);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule3 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule3.setProgramAlgoRuleID(ID);
        gradAlgorithmRule3.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity3 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity3.setAlgoRuleCode("AB");
        ruleCodeEntity3.setRuleImplementation("ABCDE");
        ruleCodeEntity3.setIsActiveRule("Y");
        gradAlgorithmRule3.setAlgorithmRuleCode(ruleCodeEntity3);
        gradAlgorithmRule3.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule3);

        final ProgramAlgorithmRuleEntity gradAlgorithmRule4 = new ProgramAlgorithmRuleEntity();
        gradAlgorithmRule4.setProgramAlgoRuleID(ID);
        gradAlgorithmRule4.setGraduationProgramCode(programCode1);
        final AlgorithmRuleCodeEntity ruleCodeEntity4 = new AlgorithmRuleCodeEntity();
        ruleCodeEntity4.setAlgoRuleCode("AB");
        ruleCodeEntity4.setRuleImplementation("ABCDEF");
        ruleCodeEntity4.setIsActiveRule("Y");
        gradAlgorithmRule4.setAlgorithmRuleCode(ruleCodeEntity4);
        gradAlgorithmRule4.setSortOrder(2);
        algorithmsRulesList.add(gradAlgorithmRule4);

        when(programAlgorithmRuleRepository.getAlgorithmRulesByProgramCode(programCode1)).thenReturn(algorithmsRulesList);
        
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
		List<SpecialCaseCodeEntity> gradSpecialCaseList = new ArrayList<>();
		SpecialCaseCodeEntity objs = new SpecialCaseCodeEntity();
		objs.setDescription("D");
		objs.setSpCase("C");
		objs.setPassFlag("Y");
		gradSpecialCaseList.add(objs);
		objs = new SpecialCaseCodeEntity();
		objs.setDescription("G");
		objs.setSpCase("T");
		objs.setPassFlag("N");
		gradSpecialCaseList.add(objs);
		Mockito.when(specialCaseRepository.findAll()).thenReturn(gradSpecialCaseList);

        var result = algorithmRuleService.getAllAlgorithmData(programCode1);

        assertThat(result).isNotNull();
        assertThat(result.getSpecialCase().get(0).getSpCase()).isEqualTo(gradSpecialCaseList.get(0).getSpCase());
	}
}
