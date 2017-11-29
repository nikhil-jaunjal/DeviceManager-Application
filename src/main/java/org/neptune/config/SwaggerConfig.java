package org.neptune.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig
{
	@Bean
	public Docket restApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfo("device", "Rest", "1.1", null, new Contact(null, null, null), null, null)).select().build();
	}

}