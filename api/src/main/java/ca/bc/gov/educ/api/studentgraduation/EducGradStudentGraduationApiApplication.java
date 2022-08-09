package ca.bc.gov.educ.api.studentgraduation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EducGradStudentGraduationApiApplication {

    private static Logger logger = LoggerFactory.getLogger(EducGradStudentGraduationApiApplication.class);

    public static void main(String[] args) {
        logger.debug("########Starting API");
        SpringApplication.run(EducGradStudentGraduationApiApplication.class, args);
        logger.debug("########Started API");
    }

}