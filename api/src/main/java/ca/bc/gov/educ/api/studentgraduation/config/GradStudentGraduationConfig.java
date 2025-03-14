package ca.bc.gov.educ.api.studentgraduation.config;

import ca.bc.gov.educ.api.studentgraduation.util.EducGradStudentGraduationApiConstants;
import ca.bc.gov.educ.api.studentgraduation.util.LogHelper;
import ca.bc.gov.educ.api.studentgraduation.util.ThreadLocalStateUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

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

		ModelMapper modelMapper = new ModelMapper();
		//modelMapper.typeMap(GradProgramEntity.class, GradProgram.class);
		//modelMapper.typeMap(GradProgram.class, GradProgramEntity.class);
		return modelMapper;
	}

	@Bean
	public WebClient webClient() {
		HttpClient client = HttpClient.create();
		client.warmup().block();
		return WebClient.builder()
				.filter(setRequestHeaders())
				.filter(this.log())
				.build();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private ExchangeFilterFunction setRequestHeaders() {
		return (clientRequest, next) -> {
			ClientRequest modifiedRequest = ClientRequest.from(clientRequest)
					.header(EducGradStudentGraduationApiConstants.CORRELATION_ID, ThreadLocalStateUtil.getCorrelationID())
					.header(EducGradStudentGraduationApiConstants.USER_NAME, ThreadLocalStateUtil.getCurrentUser())
					.header(EducGradStudentGraduationApiConstants.REQUEST_SOURCE, EducGradStudentGraduationApiConstants.API_NAME)
					.build();
			return next.exchange(modifiedRequest);
		};
	}

	private ExchangeFilterFunction log() {
		return (clientRequest, next) -> next
				.exchange(clientRequest)
				.doOnNext((clientResponse -> logHelper.logClientHttpReqResponseDetails(
						clientRequest.method(),
						clientRequest.url().toString(),
						clientResponse.statusCode().value(),
						clientRequest.headers().get(EducGradStudentGraduationApiConstants.CORRELATION_ID),
						clientRequest.headers().get(EducGradStudentGraduationApiConstants.REQUEST_SOURCE),
						constants.isSplunkLogHelperEnabled())
				));
	}

}
