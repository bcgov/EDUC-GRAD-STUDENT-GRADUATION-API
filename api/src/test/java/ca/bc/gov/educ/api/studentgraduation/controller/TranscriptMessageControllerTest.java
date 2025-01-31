package ca.bc.gov.educ.api.studentgraduation.controller;

import ca.bc.gov.educ.api.studentgraduation.model.dto.TranscriptMessage;
import ca.bc.gov.educ.api.studentgraduation.service.TranscriptMessageService;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import ca.bc.gov.educ.api.studentgraduation.util.MessageHelper;
import ca.bc.gov.educ.api.studentgraduation.util.ResponseHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class TranscriptMessageControllerTest {

	@Mock
	private TranscriptMessageService transcriptMessageService;
	
	@InjectMocks
	private TranscriptMessageController transcriptMessageController;
	
	@Mock
	ResponseHelper response;
	
	@Mock
	GradValidation validation;
	
	@Mock
	MessageHelper messagesHelper;	
	
	@Test
	void testGetAllMessagingCodeList() {
		List<TranscriptMessage> gradMessagingList = new ArrayList<>();
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
		gradMessagingList.add(obj);
		obj = new TranscriptMessage();
		obj.setProgramCode("2018-PF");
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
		gradMessagingList.add(obj);
		Mockito.when(transcriptMessageService.getAllTranscriptMessageList()).thenReturn(gradMessagingList);
		transcriptMessageController.getAllTranscriptMessageList();
		Mockito.verify(transcriptMessageService).getAllTranscriptMessageList();
	}
	
	@Test
	void testGetSpecificMessagingCode() {
		String programCode = "2018-EN";
		String msgType = "GRADUATION";
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
		Mockito.when(transcriptMessageService.getSpecificTranscriptMessageCode(programCode,msgType)).thenReturn(obj);
		transcriptMessageController.getSpecificTranscriptMessageCode(programCode,msgType);
		Mockito.verify(transcriptMessageService).getSpecificTranscriptMessageCode(programCode,msgType);
	}
	
	@Test
	void testGetSpecificMessagingCode_noContent() {
		String programCode = "2018-ENF";
		String msgType = "GRADUATION";	
		Mockito.when(transcriptMessageService.getSpecificTranscriptMessageCode(programCode,msgType)).thenReturn(null);
		transcriptMessageController.getSpecificTranscriptMessageCode(programCode,msgType);
		Mockito.verify(transcriptMessageService).getSpecificTranscriptMessageCode(programCode,msgType);
	}
	
	
	
}
