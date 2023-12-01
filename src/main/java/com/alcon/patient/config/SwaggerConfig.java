package com.alcon.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Configuration
	public class SpringFoxConfig {
		@Bean
		public OpenAPI usersMicroserviceOpenAPI() {
			return new OpenAPI()
					.info(new Info().title("Patient API's").description("Patient API Offerring").version("1.0"));
		}
	}
}