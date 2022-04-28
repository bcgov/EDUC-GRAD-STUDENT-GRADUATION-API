package ca.bc.gov.educ.api.studentgraduation.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentUngradReason;
import ca.bc.gov.educ.api.studentgraduation.model.dto.UngradReason;
import ca.bc.gov.educ.api.studentgraduation.service.StudentUngradReasonService;
import ca.bc.gov.educ.api.studentgraduation.service.UngradReasonService;
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

@CrossOrigin
@RestController
@RequestMapping(EducGradStudentGraduationApiConstants.GRAD_STUDENT_GRADUATION_UNGRAD_REASON_CONTROLLER_ROOT_MAPPING)
@OpenAPIDefinition(info = @Info(title = "API for Student and General Ungrad Reasons.", description = "This API is for Student and General Ungrad Reasons endpoints.", version = "1"), security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_GRAD_STUDENT_UNGRAD_REASONS_DATA"})})
public class UngradReasonController {

    private static Logger logger = LoggerFactory.getLogger(UngradReasonController.class);

    @Autowired
    StudentUngradReasonService studentUngradReasonService;
    
    @Autowired
	UngradReasonService ungradReasonService;
    
    @Autowired
	GradValidation validation;
    
    @Autowired
	ResponseHelper response;
    
    private static final String REASON_CODE="Reason Code";
    
    @GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_STUDENT_UNGRAD_MAPPING)
    @PreAuthorize(PermissionsContants.READ_GRAD_STUDENT_UNGRAD_REASONS_DATA)
    @Operation(summary = "Find Student Ungrad Reasons by Student ID", description = "Get Student Ungrad Reasons By Student ID", tags = { "Ungrad Reasons" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    public ResponseEntity<List<StudentUngradReason>> getAllStudentUngradReasonsList(@PathVariable String studentID) { 
    	logger.debug("getAllStudentUngradReasonsList : ");
        return response.GET(studentUngradReasonService.getAllStudentUngradReasonsList(UUID.fromString(studentID)));
    }
    
    @PostMapping(EducGradStudentGraduationApiConstants.GET_ALL_STUDENT_UNGRAD_MAPPING)
    @PreAuthorize(PermissionsContants.CREATE_GRAD_STUDENT_UNGRAD_REASONS_DATA)
    @Operation(summary = "Create an Ungrad Reasons", description = "Create an Ungrad Reasons", tags = { "Ungrad Reasons" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "400", description = "BAD REQUEST")})
    public ResponseEntity<ApiResponseModel<StudentUngradReason>> createGradStudentUngradReason(@PathVariable String studentID,@Valid @RequestBody StudentUngradReason gradStudentUngradReasons) { 
    	logger.debug("createUngradReason : ");
    	validation.requiredField(gradStudentUngradReasons.getGraduationStudentRecordID(), "Student ID");
    	validation.requiredField(gradStudentUngradReasons.getUngradReasonCode(), "Ungrad Reason Code");
    	if(validation.hasErrors()) {
    		validation.stopOnErrors();
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
        return response.CREATED(studentUngradReasonService.createStudentUngradReason(gradStudentUngradReasons));
    }
	

	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_MAPPING)
	@PreAuthorize(PermissionsContants.READ_GRAD_UNGRAD)
	@Operation(summary = "Find all Ungrad Reasons", description = "Get all Ungrad Reasons", tags = { "Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO CONTENT.") })
	public ResponseEntity<List<UngradReason>> getAllUngradReasonCodeList() {
		logger.debug("getAllUngradReasonCodeList : ");
		return response.GET(ungradReasonService.getAllUngradReasonCodeList());
	}

	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_BY_CODE_MAPPING)
	@PreAuthorize(PermissionsContants.READ_GRAD_UNGRAD)
	@Operation(summary = "Find an Ungrad Reason by Ungrad Reasons Code", description = "Get an Ungrad Reason by Ungrad Reasons Code", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "204", description = "NO CONTENT.") })
	public ResponseEntity<UngradReason> getSpecificUngradReasonCode(@PathVariable String reasonCode) {
		logger.debug("getSpecificUngradReasonCode : ");
		UngradReason gradResponse = ungradReasonService.getSpecificUngradReasonCode(reasonCode);
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
	public ResponseEntity<ApiResponseModel<UngradReason>> createUngradReason(
			@Valid @RequestBody UngradReason gradUngradReasons) {
		logger.debug("createGradUngradReason : ");
		validation.requiredField(gradUngradReasons.getCode(), REASON_CODE);
		validation.requiredField(gradUngradReasons.getDescription(), "Reason Description");
		if (validation.hasErrors()) {
			validation.stopOnErrors();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response.CREATED(ungradReasonService.createUngradReason(gradUngradReasons));
	}

	@PutMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_MAPPING)
	@PreAuthorize(PermissionsContants.UPDATE_UNGRAD_REASON)
	@Operation(summary = "Update an Ungrad Reason", description = "Update an Ungrad Reason", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST") })
	public ResponseEntity<ApiResponseModel<UngradReason>> updateUngradReason(
			@Valid @RequestBody UngradReason gradUngradReasons) {
		logger.info("updateUngradReason : ");
		validation.requiredField(gradUngradReasons.getCode(), REASON_CODE);
		validation.requiredField(gradUngradReasons.getDescription(), "Reason Description");
		if (validation.hasErrors()) {
			validation.stopOnErrors();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response.UPDATED(ungradReasonService.updateUngradReason(gradUngradReasons));
	}

	@DeleteMapping(EducGradStudentGraduationApiConstants.GET_ALL_UNGRAD_BY_CODE_MAPPING)
	@PreAuthorize(PermissionsContants.DELETE_UNGRAD_REASON)
	@Operation(summary = "Delete an Ungrad Reason", description = "Delete an Ungrad Reason", tags = {
			"Ungrad Reasons" })
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST") })
	public ResponseEntity<Void> deleteUngradReason(@Valid @PathVariable String reasonCode) {
		logger.debug("deleteGradUngradReason : ");
		validation.requiredField(reasonCode, REASON_CODE);
		if (validation.hasErrors()) {
			validation.stopOnErrors();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response.DELETE(ungradReasonService.deleteUngradReason(reasonCode));
	}
}
