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
    public static final String GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING = "/api/" + API_VERSION;
    
    public static final String GRAD_STUDENT_GRADUATION_LGSC_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/lgSc";
    public static final String GRAD_STUDENT_GRADUATION_UNGRAD_REASON_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/ungrad";
    public static final String GRAD_STUDENT_GRADUATION_TRANSCRIPT_MESSAGE_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/transcript";
    
    public static final String GET_ALL_SPECIAL_CASE_MAPPING = "/specialcase";
    public static final String GET_ALL_LETTER_GRADE_MAPPING = "/lettergrade";
    public static final String GET_ALL_SPECIAL_CASE__BY_SPECIAL_CODE = "/specialcase/{specialCode}";
    public static final String GET_ALL_LETTER_GRADE__BY_LETTER_GRADE = "/lettergrade/{letterGrade}";

    //Code
    public static final String GET_ALL_UNGRAD_MAPPING = "/ungradreason";
    public static final String GET_ALL_UNGRAD_BY_CODE_MAPPING = "/ungradreason/{reasonCode}";
    
    public static final String GET_ALL_GRAD_MESSAGING_MAPPING = "/gradmessages";
    public static final String GET_ALL_GRAD_MESSAGING_BY_PRG_CODE_AND_MESSAGE_TYPE_MAPPING = "/gradmessages/pgmCode/{pgmCode}/msgType/{msgType}";
    //
    
    //Common
    public static final String GET_ALL_STUDENT_UNGRAD_MAPPING = "/studentungradreason/studentid/{studentID}";
    
    
   
    //Default Attribute value constants
    public static final String DEFAULT_CREATED_BY = "API_STUDENT_GRADUATION";
    public static final Date DEFAULT_CREATE_DATE = new Date();
    public static final String DEFAULT_UPDATED_BY = "API_STUDENT_GRADUATION";
    public static final Date DEFAULT_UPDATE_DATE = new Date();

    //Default Date format constants
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    
    public static final String TRAX_DATE_FORMAT = "yyyyMM";
    
    @Value("${endpoint.code-api.program-type_by_code.url}")
    private String gradProgramTypeByCode;
    
    @Value("${endpoint.code-api.requirement-type_by_code.url}")
    private String gradRequirementTypeByCode;
}
