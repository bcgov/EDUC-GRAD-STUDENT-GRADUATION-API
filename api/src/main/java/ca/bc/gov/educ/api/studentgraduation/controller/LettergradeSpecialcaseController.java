package ca.bc.gov.educ.api.studentgraduation.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.bc.gov.educ.api.studentgraduation.model.dto.LetterGrade;
import ca.bc.gov.educ.api.studentgraduation.model.dto.SpecialCase;
import ca.bc.gov.educ.api.studentgraduation.service.LetterGradeService;
import ca.bc.gov.educ.api.studentgraduation.service.SpecialCaseService;
import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
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
@RequestMapping(EducGradStudentGraduationApiConstants.GRAD_STUDENT_GRADUATION_LGSC_CONTROLLER_ROOT_MAPPING)
@OpenAPIDefinition(info = @Info(title = "API for Letter Grade and Special Case Data.", description = "This API contains endpoints for Letter Grade and Special Case data.", version = "1"), security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_GRAD_SPECIAL_CASE_DATA","READ_GRAD_LETTER_GRADE_DATA"})})
public class LettergradeSpecialcaseController {

    LetterGradeService letterGradeService;
    SpecialCaseService specialCaseService;
	ResponseHelper response;

    @Autowired
    public LettergradeSpecialcaseController(LetterGradeService letterGradeService, SpecialCaseService specialCaseService,
                                            ResponseHelper response) {
        this.letterGradeService = letterGradeService;
        this.specialCaseService = specialCaseService;
        this.response = response;
    }
    
    @GetMapping(value=EducGradStudentGraduationApiConstants.GET_ALL_SPECIAL_CASE_MAPPING,produces= {"application/json"})
    @PreAuthorize(PermissionsContants.READ_GRAD_SPECIAL_CASE)
    @Operation(summary = "Find All Special Cases", description = "Get All Special Cases", tags = { "Independent" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "204", description = "NO CONTENT.")})
    public ResponseEntity<List<SpecialCase>> getAllSpecialCases() { 
    	log.debug("getAllSpecialCases : ");
    	List<SpecialCase> specialList = specialCaseService.getAllSpecialCaseList();
    	if(!specialList.isEmpty()) {
    		return response.GET(specialList,new TypeToken<List<SpecialCase>>() {}.getType());
    	}
    	return response.NO_CONTENT();
    }
    
    @GetMapping(value=EducGradStudentGraduationApiConstants.GET_ALL_SPECIAL_CASE__BY_SPECIAL_CODE,produces= {"application/json"})
    @Operation(summary = "Find a Specific Special Case", description = "Get a Special Cases", tags = { "Independent" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "204", description = "NO CONTENT.")})
    @PreAuthorize(PermissionsContants.READ_GRAD_SPECIAL_CASE)
    public ResponseEntity<SpecialCase> getSpecificSpecialCases(@PathVariable String specialCode) {
        log.debug("getSpecificSpecialCases : ");
    	SpecialCase gradSpecialCase = specialCaseService.getSpecificSpecialCase(specialCode);
    	if(gradSpecialCase != null) {
    		return response.GET(gradSpecialCase) ;
    	}
    	return response.NO_CONTENT();
    }

    @GetMapping(value=EducGradStudentGraduationApiConstants.GET_ALL_LETTER_GRADE_MAPPING,produces= {"application/json"})
    @PreAuthorize(PermissionsContants.READ_GRAD_LETTER_GRADE)
    @Operation(summary = "Find All Letter Grade", description = "Get All Letter Grades", tags = { "Independent" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "204", description = "NO CONTENT.")})
    public List<LetterGrade> getAllLetterGrades() {
        log.debug("getAllLetterGrades : ");
        return letterGradeService.getAllLetterGradesList();
    }
    
    @GetMapping(value=EducGradStudentGraduationApiConstants.GET_ALL_LETTER_GRADE__BY_LETTER_GRADE,produces= {"application/json"})
    @Operation(summary = "Find a Specific Letter Grade", description = "Get a Letter Grade", tags = { "Independent" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    @PreAuthorize(PermissionsContants.READ_GRAD_LETTER_GRADE)
    public LetterGrade getSpecificLetterGrade(@PathVariable String letterGrade) {
        log.debug("getSpecificLetterGrade : ");
        return letterGradeService.getSpecificLetterGrade(letterGrade);
    }  
}