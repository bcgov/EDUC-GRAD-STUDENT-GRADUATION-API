package ca.bc.gov.educ.api.studentgraduation.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import ca.bc.gov.educ.api.studentgraduation.model.dto.ProgramAlgorithmRule;
import ca.bc.gov.educ.api.studentgraduation.model.dto.StudentGraduationAlgorithmData;
import ca.bc.gov.educ.api.studentgraduation.service.AlgorithmRuleService;
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
@RequestMapping(EducGradStudentGraduationApiConstants.GRAD_STUDENT_GRADUATION_ALGO_CONTROLLER_ROOT_MAPPING)
@OpenAPIDefinition(info = @Info(title = "API for Algorithm Rule Data.", description = "This API contains endpoints for Algorithm Rule data.", version = "1"), security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_GRAD_SPECIAL_CASE_DATA","READ_GRAD_LETTER_GRADE_DATA"})})
public class AlgorithmRuleController {

	private static Logger logger = LoggerFactory.getLogger(AlgorithmRuleController.class);

    @Autowired
    AlgorithmRuleService algorithmRuleService;
    
    @Autowired
	GradValidation validation;
    
    @Autowired
	ResponseHelper response;
    
	@GetMapping(EducGradStudentGraduationApiConstants.GET_ALGORITHM_RULES_MAIN_PROGRAM)
    @PreAuthorize(PermissionsContants.READ_GRAD_ALGORITHM_RULES)
    @Operation(summary = "Read All  Grad Algorithm Rules by Program Code", description = "Read All  Grad Algorithm Rules by Program Code which are active", tags = { "Algorithm" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    public ResponseEntity<List<ProgramAlgorithmRule>> getAlgorithmRulesList(@PathVariable String programCode) { 
    	logger.debug("getAlgorithmRulesList : ");
        return response.GET(algorithmRuleService.getAlgorithmRulesList(programCode));
    }
    
    @GetMapping(EducGradStudentGraduationApiConstants.GET_ALL_ALGORITHM_RULES_MAPPING)
    @PreAuthorize(PermissionsContants.READ_GRAD_ALGORITHM_RULES)
    @Operation(summary = "Read All  Grad Algorithm Rules", description = "Read All  Grad Algorithm Rules", tags = { "Algorithm" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    public ResponseEntity<List<ProgramAlgorithmRule>> getAllAlgorithmRulesList() { 
    	logger.debug("getAllAlgorithmRulesList : ");
        return response.GET(algorithmRuleService.getAllAlgorithmRulesList());
    }
    
    
    @GetMapping(EducGradStudentGraduationApiConstants.GET_DATA_FOR_ALGORITHM_MAPPING)
    @PreAuthorize(PermissionsContants.READ_ALGORITHM_DATA)
    @Operation(summary = "Read All  Data required by Grad Algorithm", description = "Read All  Data required by Grad Algorithm", tags = { "Algorithm" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    public ResponseEntity<StudentGraduationAlgorithmData> getAllAlgorithmData(@PathVariable String programCode) { 
    	logger.debug("getAllAlgorithmData : ");
        return response.GET(algorithmRuleService.getAllAlgorithmData(programCode));
    }

    @GetMapping(EducGradStudentGraduationApiConstants.GET_DATA_FOR_ALGORITHM_LIST_MAPPING)
    @PreAuthorize(PermissionsContants.READ_ALGORITHM_DATA)
    @Operation(summary = "Read All  Data required by Grad Algorithm", description = "Read All  Data required by Grad Algorithm", tags = { "Algorithm" })
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    public ResponseEntity<List<StudentGraduationAlgorithmData>> getAllAlgorithmDataList(@RequestHeader(name="Authorization") String accessToken) {
        logger.debug("getAllAlgorithmData : ");
        return response.GET(algorithmRuleService.getAllAlgorithmDataList(accessToken.replace("Bearer ", "")));
    }
    
}
