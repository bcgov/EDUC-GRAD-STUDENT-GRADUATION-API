package ca.bc.gov.educ.api.studentgraduation.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class EducGradStudentGraduationApiConstants {

    //API end-point Mapping constants
    public static final String API_ROOT_MAPPING = "";
    public static final String API_VERSION = "v1";
    public static final String GRAD_PROGRAM_MANAGEMENT_API_ROOT_MAPPING = "/api/" + API_VERSION + "/studentgraduation";
    public static final String GET_ALL_PROGRAM_MAPPING = "/programs";
    public static final String GET_ALL_SPECIAL_PROGRAM_MAPPING = "/specialprograms";
    public static final String GET_ALL_SPECIAL_PROGRAM_BY_PROGRAM_CODE_MAPPING = "/specialprograms/{programCode}";
    public static final String GET_ALL_SPECIAL_PROGRAM_BY_PROGRAM_CODE_AND_SPECIAL_PROGRAM_MAPPING = "/specialprograms/{programCode}/{specialProgramCode}";
    public static final String GET_ALL_SPECIAL_CASE_MAPPING = "/specialcase";
    public static final String GET_ALL_LETTER_GRADE_MAPPING = "/lettergrade";
    public static final String DELETE_PROGRAM_MAPPING = "/programs/{programCode}";
    public static final String DELETE_SPECIAL_PROGRAM_MAPPING = "/specialprograms/{specialProgramID}";
    public static final String GET_PROGRAM_MAPPING = "/programs/{programCode}";
    public static final String DELETE_PROGRAM_RULES_MAPPING = "/programrules/{programRuleID}";
    public static final String DELETE_SPECIAL_PROGRAM_RULES_MAPPING = "/specialprogramrules/{programRuleID}";
    public static final String GET_ALL_SPECIAL_PROGRAM_MAPPING_BY_ID = "/specialprograms/id/{specialProgramID}";

    //Attribute Constants
    public static final String GET_ALL_PROGRAM_SETS_BY_PROGRAM_CODE = "/programsets/{programCode}";
    public static final String GET_PROGRAM_BY_PROGRAM_TYPE = "/programtype/{typeCode}";
    public static final String GET_REQUIREMENT_BY_REQUIREMENT_TYPE = "/requirementtype/{typeCode}";
    public static final String GRAD_PROGRAM_SETS = "/programsets";
    public static final String GET_ALL_PROGRAM_RULES = "/programrules";
    public static final String GET_PROGRAM_RULES = "/allprogramrules";
    public static final String GET_ALL_SPECIAL_PROGRAM_RULES = "/specialprogramrules";
    public static final String GET_SPECIAL_PROGRAM_RULES = "/allspecialprogramrules";
    public static final String GET_SPECIAL_PROGRAM_RULES_BY_PROGRAM_CODE_AND_SPECIAL_PROGRAM_CODE = "/specialprogramrules/{programCode}/{specialProgramCode}/{requirementType}";
    public static final String GET_SPECIAL_PROGRAM_RULES_BY_PROGRAM_CODE_AND_SPECIAL_PROGRAM_CODE_ONLY = "/specialprogramrules/{programCode}/{specialProgramCode}";
    public static final String GET_ALL_SPECIAL_CASE__BY_SPECIAL_CODE = "/specialcase/{specialCode}";
    public static final String GET_ALL_LETTER_GRADE__BY_LETTER_GRADE = "/lettergrade/{letterGrade}";
    public static final String GET_ALL_SPECIFIC_PROGRAM_RULES_BY_RULE = "/programrules/{ruleCode}";
    
    //Default Attribute value constants
    public static final String DEFAULT_CREATED_BY = "ProgramManagementAPI";
    public static final Date DEFAULT_CREATED_TIMESTAMP = new Date();
    public static final String DEFAULT_UPDATED_BY = "ProgramManagementAPI";
    public static final Date DEFAULT_UPDATED_TIMESTAMP = new Date();

    //Default Date format constants
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    
    public static final String TRAX_DATE_FORMAT = "yyyyMM";
    
    @Value("${endpoint.code-api.program-type_by_code.url}")
    private String gradProgramTypeByCode;
    
    @Value("${endpoint.code-api.requirement-type_by_code.url}")
    private String gradRequirementTypeByCode;
}
