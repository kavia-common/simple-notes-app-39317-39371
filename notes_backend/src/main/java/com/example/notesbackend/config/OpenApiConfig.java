package com.example.notesbackend.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * PUBLIC_INTERFACE
 * Configures OpenAPI documentation metadata.
 */
@Configuration
public class OpenApiConfig {

    // PUBLIC_INTERFACE
    @Bean
    public OpenAPI notesOpenAPI() {
        /** Provide OpenAPI metadata for the Notes API. */
        return new OpenAPI()
                .info(new Info()
                        .title("Simple Notes API")
                        .version("0.1.0")
                        .description("REST API for creating, reading, updating, and deleting notes.")
                        .contact(new Contact().name("Notes Backend").url("https://example.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Swagger UI")
                        .url("/swagger-ui.html"));
    }
}
