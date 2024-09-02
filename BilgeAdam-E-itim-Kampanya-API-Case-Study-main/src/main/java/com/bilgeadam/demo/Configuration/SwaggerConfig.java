package com.bilgeadam.demo.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// for OpernAPI/Swagger documentation
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Campaign Management API")
                        .description("API documentation for managing campaigns in the BilgeAdam educational project.")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("BilgeAdam Support")
                                .url("https://www.bilgeadam.com")
                                .email("support@bilgeadam.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("BilgeAdam Documentation")
                        .url("https://www.bilgeadam.com/docs"))
                .tags(List.of(
                        new Tag().name("Campaign Controller").description("API for managing campaigns")));
    }
}
