package com.example.jobsearch.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "JOB SEARCH APPLICATION REST API", version = "1.0",
        description = "REST API",
        contact = @Contact(name = "Oleg Rulyov")))
public class OpenApiConfig {
}
