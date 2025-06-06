package ca.bc.gov.educ.api.studentgraduation.config;

import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import ca.bc.gov.educ.api.studentgraduation.util.LogHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GradStudentGraduationConfig {

	EducGradStudentGraduationApiConstants constants;
	LogHelper logHelper;

	@Autowired
	public GradStudentGraduationConfig(EducGradStudentGraduationApiConstants constants, LogHelper logHelper) {
		this.constants = constants;
		this.logHelper = logHelper;
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
