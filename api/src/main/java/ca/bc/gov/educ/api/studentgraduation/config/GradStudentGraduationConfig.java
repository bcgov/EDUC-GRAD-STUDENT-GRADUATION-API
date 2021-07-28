package ca.bc.gov.educ.api.studentgraduation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ca.bc.gov.educ.api.studentgraduation.util.MessageHelper;

@Configuration
@PropertySource("classpath:messages.properties")
public class GradStudentGraduationConfig implements WebMvcConfigurer {

	@Autowired
	RequestInterceptor requestInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}

	@Bean
	public MessageHelper messageHelper() {
		return new MessageHelper();
	}

	
}
