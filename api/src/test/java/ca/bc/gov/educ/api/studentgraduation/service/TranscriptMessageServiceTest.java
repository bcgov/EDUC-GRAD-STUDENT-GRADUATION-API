package ca.bc.gov.educ.api.studentgraduation.service;

import ca.bc.gov.educ.api.studentgraduation.model.dto.TranscriptMessage;
import ca.bc.gov.educ.api.studentgraduation.model.entity.TranscriptMessageEntity;
import ca.bc.gov.educ.api.studentgraduation.repository.TranscriptMessageRepository;
import ca.bc.gov.educ.api.studentgraduation.repository.UndoCompletionReasonRepository;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
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

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TranscriptMessageServiceTest {

	@Autowired
	private TranscriptMessageService transcriptMessageService;
	
	@Autowired
	private UndoCompletionReasonService undoCompletionReasonService;
	
	@MockBean
	private UndoCompletionReasonRepository gradUndoCompletionReasonsRepository;

	@MockBean
	private TranscriptMessageRepository gradMessagingRepository;

	@Autowired
	GradValidation validation;

	@MockBean
	@Qualifier("studentGraduationApiClient")
	WebClient studentGraduationApiClient;
	
	@Test
	public void testGetAllMessagingCodeList() {
		List<TranscriptMessageEntity> gradMessageList = new ArrayList<>();
		TranscriptMessageEntity obj = new TranscriptMessageEntity();
		obj.setGraduationProgramCode("2018-EN");
		obj.setMessageTypeCode("GRADUATED");
		obj.setAdIBProgramMessage("A");
		obj.setCareerProgramMessage("CP");
		obj.setGradDateMessage("GD");
		obj.setHonourNote("Y");
		obj.setGradMainMessage("abcd");
		obj.setFrenchImmersionMessage("PR");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		
		gradMessageList.add(obj);
		obj = new TranscriptMessageEntity();
		obj.setGraduationProgramCode("2018-PF");
		obj.setMessageTypeCode("GRADUATED");
		obj.setAdIBProgramMessage("A");
		obj.setCareerProgramMessage("CP");
		obj.setGradDateMessage("GD");
		obj.setHonourNote("Y");
		obj.setGradMainMessage("abcd");
		obj.setFrenchImmersionMessage("PR");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		gradMessageList.add(obj);
		Mockito.when(gradMessagingRepository.findAll()).thenReturn(gradMessageList);
		transcriptMessageService.getAllTranscriptMessageList();
	}
	
	@Test
	public void testGetSpecificTranscriptMessageCode() {
		String programCode = "2018-EN";
		String msgType = "GRADUATED";
		TranscriptMessage obj = new TranscriptMessage();
		obj.setProgramCode("2018-EN");
		obj.setMessageTypeCode("GRADUATED");
		obj.setAdIBProgramMessage("A");
		obj.setCareerProgramMessage("CP");
		obj.setGradDateMessage("GD");
		obj.setHonourNote("Y");
		obj.setGradMainMessage("abcd");
		obj.setFrenchImmersionMessage("PR");
		obj.setCreateUser("GRADUATION");
		obj.setUpdateUser("GRADUATION");
		obj.setCreateDate(new Date(System.currentTimeMillis()));
		obj.setUpdateDate(new Date(System.currentTimeMillis()));
		obj.toString();
		TranscriptMessageEntity objEntity = new TranscriptMessageEntity();
		objEntity.setGraduationProgramCode("2018-EN");
		objEntity.setMessageTypeCode("GRADUATED");
		objEntity.setAdIBProgramMessage("A");
		objEntity.setCareerProgramMessage("CP");
		objEntity.setGradDateMessage("GD");
		objEntity.setHonourNote("Y");
		objEntity.setGradMainMessage("abcd");
		objEntity.setFrenchImmersionMessage("PR");
		objEntity.setCreateUser("GRADUATION");
		objEntity.setUpdateUser("GRADUATION");
		objEntity.setCreateDate(new Date(System.currentTimeMillis()));
		objEntity.setUpdateDate(new Date(System.currentTimeMillis()));
		Optional<TranscriptMessageEntity> ent = Optional.of(objEntity);
		Mockito.when(gradMessagingRepository.findByGraduationProgramCodeAndMessageTypeCode(programCode,msgType)).thenReturn(ent);
		transcriptMessageService.getSpecificTranscriptMessageCode(programCode,msgType);
		
	}
	
	@Test
	public void testGetSpecificMessageCodeReturnsNull() {
		String programCode = "2018-FN";
		String msgType = "GRADUATED";
		Mockito.when(gradMessagingRepository.findByGraduationProgramCodeAndMessageTypeCode(programCode,msgType)).thenReturn(Optional.empty());
		transcriptMessageService.getSpecificTranscriptMessageCode(programCode,msgType);
		
	}
}