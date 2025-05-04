package ca.bc.gov.educ.api.studentgraduation.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.bc.gov.educ.api.studentgraduation.model.dto.TranscriptMessage;
import ca.bc.gov.educ.api.studentgraduation.service.TranscriptMessageService;
import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import ca.bc.gov.educ.api.studentgraduation.util.GradValidation;
import ca.bc.gov.educ.api.studentgraduation.util.PermissionsContants;
import ca.bc.gov.educ.api.studentgraduation.util.ResponseHelper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(EducGradStudentGraduationApiConstants.GRAD_STUDENT_GRADUATION_TRANSCRIPT_MESSAGE_CONTROLLER_ROOT_MAPPING)
@CrossOrigin
@OpenAPIDefinition(info = @Info(title = "API for Transcript Messages Data.", description = "This API is for Transcript Messages Data.", version = "1"), security = {
		@SecurityRequirement(name = "OAUTH2", scopes = { "READ_GRAD_UNGRAD_CODE_DATA",
				"READ_GRAD_MESSEGING_CODE_DATA" }) })
@AllArgsConstructor
public class TranscriptMessageController {

	private TranscriptMessageService transcriptMessageService;
	
	GradValidation validation;

	ResponseHelper response;
	    
	private static Logger logger = LoggerFactory.getLogger(TranscriptMessageController.class);

	

	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_GRAD_MESSAGING_MAPPING)
	@PreAuthorize(PermissionsContants.READ_GRAD_MESSAGING)
	@Operation(summary = "Find all Grad Messaging", description = "Get all Grad Messaging", tags = {
			"Graduation Messages" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK") })
	public ResponseEntity<List<TranscriptMessage>> getAllTranscriptMessageList() {
		logger.debug("getAllTranscriptMessageList : ");
		return response.GET(transcriptMessageService.getAllTranscriptMessageList());
	}

	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_GRAD_MESSAGING_BY_PRG_CODE_AND_MESSAGE_TYPE_MAPPING)
	@PreAuthorize(PermissionsContants.READ_GRAD_MESSAGING)
	@Operation(summary = "Find a Grad Messaging", description = "Get a Grad Messaging", tags = {
			"Graduation Messages" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO CONTENT") })
	public ResponseEntity<TranscriptMessage> getSpecificTranscriptMessageCode(@PathVariable String pgmCode,
			@PathVariable String msgType) {
		logger.debug("getSpecificTranscriptMessageCode : ");
		TranscriptMessage gradResponse = transcriptMessageService.getSpecificTranscriptMessageCode(pgmCode, msgType);
		if (gradResponse != null) {
			return response.GET(gradResponse);
		} else {
			return response.NO_CONTENT();
		}
	}
}
