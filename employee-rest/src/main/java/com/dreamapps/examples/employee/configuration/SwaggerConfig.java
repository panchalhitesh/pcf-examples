package com.dreamapps.examples.employee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {                                    
    /*@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dreamapps.examples.employee.controller"))
				.paths(PathSelectors.ant("/employees/*"))
				.build()
				.apiInfo(apiInfo());
	}


	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Employee REST API",
				"Employee accessor API.",
				"API Initial",
				"Terms of service",
				 new Contact("Hitesh Panchal", "www.google.com", "hiteshnpanchal76@gmail.com"),
				"License of API", "API license URL", Collections.emptyList());
	}*/
}