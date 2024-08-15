package com.ecommercek.ecommercek.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
                .info(new Info()
                .title("Ecommerce API")
                .version("1.0.0")
                .description("Documentation API E-commerce"));
	}
	
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi
        		.builder()
                .group("public")
                .pathsToMatch("/**")
                .build();
    }
	
	
}	
