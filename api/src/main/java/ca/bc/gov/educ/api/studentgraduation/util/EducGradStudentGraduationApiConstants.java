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

    public static final String CORRELATION_ID = "correlationID";
    public static final String USER_NAME = "User-Name";
    public static final String REQUEST_SOURCE = "Request-Source";
    public static final String API_NAME = "EDUC-GRAD-STUDENT-GRADUATION-API";
    //API end-point Mapping constants
    public static final String API_ROOT_MAPPING = "";
    public static final String API_VERSION = "v1";
    public static final String GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING = "/api/" + API_VERSION+"/studentgraduation";
    
    public static final String GRAD_STUDENT_GRADUATION_LGSC_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/lgSc";
    public static final String GRAD_STUDENT_GRADUATION_UNGRAD_REASON_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/undocompletion";
    public static final String GRAD_STUDENT_GRADUATION_TRANSCRIPT_MESSAGE_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/transcript";
    public static final String GRAD_STUDENT_GRADUATION_ALGO_CONTROLLER_ROOT_MAPPING = GRAD_STUDENT_GRADUATION_API_ROOT_MAPPING + "/algo";
    
    public static final String GET_ALL_SPECIAL_CASE_MAPPING = "/specialcase";
    public static final String GET_ALL_LETTER_GRADE_MAPPING = "/lettergrade";
    public static final String GET_ALL_SPECIAL_CASE__BY_SPECIAL_CODE = "/specialcase/{specialCode}";
    public static final String GET_ALL_LETTER_GRADE__BY_LETTER_GRADE = "/lettergrade/{letterGrade}";

    //Code
    public static final String GET_ALL_UNGRAD_MAPPING = "/undocompletionreason";
    public static final String GET_ALL_UNGRAD_BY_CODE_MAPPING = "/undocompletionreason/{reasonCode}";
    
    public static final String GET_ALL_GRAD_MESSAGING_MAPPING = "/gradmessages";
    public static final String GET_ALL_GRAD_MESSAGING_BY_PRG_CODE_AND_MESSAGE_TYPE_MAPPING = "/gradmessages/pgmCode/{pgmCode}/msgType/{msgType}";
    //
    
    //Common
    public static final String GET_ALL_STUDENT_UNGRAD_MAPPING = "/studentundocompletionreason/studentid/{studentID}";
    public static final String GET_ALL_ALGORITHM_RULES_MAPPING= "/algorithm-rules";    
    public static final String GET_ALGORITHM_RULES_MAIN_PROGRAM = "/algorithm-rules/{programCode}";
    public static final String GET_DATA_FOR_ALGORITHM_MAPPING = "/algorithmdata/{programCode}";
    public static final String GET_DATA_FOR_ALGORITHM_LIST_MAPPING = "/algorithmdata";
    
   
    //Default Attribute value constants
    public static final String DEFAULT_CREATED_BY = "API_STUDENT_GRADUATION";
    public static final Date DEFAULT_CREATE_DATE = new Date();
    public static final String DEFAULT_UPDATED_BY = "API_STUDENT_GRADUATION";
    public static final Date DEFAULT_UPDATE_DATE = new Date();

    //Default Date format constants
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    
    public static final String TRAX_DATE_FORMAT = "yyyyMM";

    // Splunk LogHelper Enabled
    @Value("${splunk.log-helper.enabled}")
    private boolean splunkLogHelperEnabled;

    @Value("${endpoint.grad-program-api.get-all-program.url}")
    private String programList;

    @Value("${endpoint.keycloak.token-uri}")
    private String tokenUrl;
}
