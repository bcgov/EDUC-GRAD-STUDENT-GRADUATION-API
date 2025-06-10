package ca.bc.gov.educ.api.studentgraduation.controller;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UndoCompletionReason;
import ca.bc.gov.educ.api.studentgraduation.service.StudentUndoCompletionReasonService;
import ca.bc.gov.educ.api.studentgraduation.service.UndoCompletionReasonService;
import ca.bc.gov.educ.api.studentgraduation.util.ApiResponseModel;
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

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(EducGradStudentGraduationApiConstants.GRAD_STUDENT_GRADUATION_UNGRAD_REASON_CONTROLLER_ROOT_MAPPING)
@OpenAPIDefinition(info = @Info(title = "API for Student and General Ungrad Reasons.", description = "This API is for Student and General Ungrad Reasons endpoints.", version = "1"), security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_GRAD_STUDENT_UNGRAD_REASONS_DATA"})})
public class UndoCompletionReasonController {

    StudentUndoCompletionReasonService studentUndoCompletionReasonService;
	UndoCompletionReasonService ungradReasonService;
	GradValidation validation;
	ResponseHelper response;
    
    private static final String REASON_CODE="Reason Code";

	@Autowired
	public UndoCompletionReasonController(StudentUndoCompletionReasonService studentUndoCompletionReasonService,
										  UndoCompletionReasonService ungradReasonService, GradValidation validation,
										  ResponseHelper response) {
		this.studentUndoCompletionReasonService = studentUndoCompletionReasonService;
		this.ungradReasonService = ungradReasonService;
		this.validation = validation;
		this.response = response;
	}
    
    @GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_STUDENT_UNGRAD_MAPPING)
    @PreAuthorize(PermissionsContants.READ_GRAD_STUDENT_UNGRAD_REASONS_DATA)
    @Operation(summary = "Find Student Ungrad Reasons by Student ID", description = "Get Student Ungrad Reasons By Student ID", tags = { "Ungrad Reasons" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    public ResponseEntity<List<StudentUndoCompletionReason>> getAllStudentUndoCompletionReasonsList(@PathVariable String studentID) { 
    	log.debug("getAllStudentUndoCompletionReasonsList : ");
        return response.GET(studentUndoCompletionReasonService.getAllStudentUndoCompletionReasonsList(UUID.fromString(studentID)));
    }
    
    @PostMapping(EducGradStudentGraduationApiConstants.GET_ALL_STUDENT_UNGRAD_MAPPING)
    @PreAuthorize(PermissionsContants.CREATE_GRAD_STUDENT_UNGRAD_REASONS_DATA)
    @Operation(summary = "Create an Ungrad Reasons", description = "Create an Ungrad Reasons", tags = { "Ungrad Reasons" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "400", description = "BAD REQUEST")})
    public ResponseEntity<ApiResponseModel<StudentUndoCompletionReason>> createGradStudentUndoCompletionReason(@PathVariable String studentID,@Valid @RequestBody StudentUndoCompletionReason gradStudentUndoCompletionReasons) {
		log.debug("createUndoCompletionReason : ");
    	validation.requiredField(gradStudentUndoCompletionReasons.getGraduationStudentRecordID(), "Student ID");
    	validation.requiredField(gradStudentUndoCompletionReasons.getUndoCompletionReasonCode(), "Ungrad Reason Code");
    	if(validation.hasErrors()) {
    		validation.stopOnErrors();
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
        return response.CREATED(studentUndoCompletionReasonService.createStudentUndoCompletionReason(gradStudentUndoCompletionReasons));
    }
	

	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_MAPPING)
	@PreAuthorize(PermissionsContants.READ_GRAD_UNGRAD)
	@Operation(summary = "Find all Ungrad Reasons", description = "Get all Ungrad Reasons", tags = { "Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO CONTENT.") })
	public ResponseEntity<List<UndoCompletionReason>> getAllUndoCompletionReasonCodeList() {
		log.debug("getAllUndoCompletionReasonCodeList : ");
		return response.GET(ungradReasonService.getAllUndoCompletionReasonCodeList());
	}

	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_BY_CODE_MAPPING)
	@PreAuthorize(PermissionsContants.READ_GRAD_UNGRAD)
	@Operation(summary = "Find an Ungrad Reason by Ungrad Reasons Code", description = "Get an Ungrad Reason by Ungrad Reasons Code", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO CONTENT.") })
	public ResponseEntity<UndoCompletionReason> getSpecificUndoCompletionReasonCode(@PathVariable String reasonCode) {
		log.debug("getSpecificUndoCompletionReasonCode : ");
		UndoCompletionReason gradResponse = ungradReasonService.getSpecificUndoCompletionReasonCode(reasonCode);
		if (gradResponse != null) {
			return response.GET(gradResponse);
		} else {
			return response.NO_CONTENT();
		}

	}

	@PostMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_MAPPING)
	@PreAuthorize(PermissionsContants.CREATE_UNGRAD_REASON)
	@Operation(summary = "Create an Ungrad Reason", description = "Create an Ungrad Reason", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST") })
	public ResponseEntity<ApiResponseModel<UndoCompletionReason>> createUndoCompletionReason(
			@Valid @RequestBody UndoCompletionReason gradUndoCompletionReasons) {
		log.debug("createGradUndoCompletionReason : ");
		validation.requiredField(gradUndoCompletionReasons.getCode(), REASON_CODE);
		validation.requiredField(gradUndoCompletionReasons.getDescription(), "Reason Description");
		if (validation.hasErrors()) {
			validation.stopOnErrors();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response.CREATED(ungradReasonService.createUndoCompletionReason(gradUndoCompletionReasons));
	}

	@PutMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_MAPPING)
	@PreAuthorize(PermissionsContants.UPDATE_UNGRAD_REASON)
	@Operation(summary = "Update an Ungrad Reason", description = "Update an Ungrad Reason", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST") })
	public ResponseEntity<ApiResponseModel<UndoCompletionReason>> updateUndoCompletionReason(
			@Valid @RequestBody UndoCompletionReason gradUndoCompletionReasons) {
		log.debug("updateUndoCompletionReason : ");
		validation.requiredField(gradUndoCompletionReasons.getCode(), REASON_CODE);
		validation.requiredField(gradUndoCompletionReasons.getDescription(), "Reason Description");
		if (validation.hasErrors()) {
			validation.stopOnErrors();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response.UPDATED(ungradReasonService.updateUndoCompletionReason(gradUndoCompletionReasons));
	}

	@DeleteMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_BY_CODE_MAPPING)
	@PreAuthorize(PermissionsContants.DELETE_UNGRAD_REASON)
	@Operation(summary = "Delete an Ungrad Reason", description = "Delete an Ungrad Reason", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST") })
	public ResponseEntity<Void> deleteUndoCompletionReason(@Valid @PathVariable String reasonCode) {
		log.debug("deleteGradUndoCompletionReason : ");
		validation.requiredField(reasonCode, REASON_CODE);
		if (validation.hasErrors()) {
			validation.stopOnErrors();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response.DELETE(ungradReasonService.deleteUndoCompletionReason(reasonCode));
	}
}
