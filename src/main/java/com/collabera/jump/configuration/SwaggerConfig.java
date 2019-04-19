package com.collabera.jump.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.License;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
	public Docket ourApi()
	{
		Docket dock =  new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.collabera.jump")).build();
		
		@SuppressWarnings("rawtypes")
		Collection<VendorExtension> extensions = new ArrayList<>();
		Contact contact = new Contact("Joseph Tobon", "https://github.com/JoeTobon", "tobonjoe@outlook.com");
		ApiInfo apiInfo = new ApiInfo("Joe's Employee API", "System to manage employees", "1.0.0", "https://www.termsfeed.com/terms-service/09a94ac6d7527e63501bb55b18d41896", contact, "MIT License", "https://opensource.org/licenses/MIT", extensions);
		dock.apiInfo(apiInfo);
		dock.useDefaultResponseMessages(false);
		
		return dock;
	}
}
