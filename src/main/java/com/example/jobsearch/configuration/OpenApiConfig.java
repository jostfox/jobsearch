package com.example.jobsearch.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(
        title = "Job Search application",
        description = "Data processing application for hiring companies",
        contact = @Contact(
                name = "Oleg Rulyov",
                email = "orulyov81@gmail.com"
        )
))
public class OpenApiConfig {
}
