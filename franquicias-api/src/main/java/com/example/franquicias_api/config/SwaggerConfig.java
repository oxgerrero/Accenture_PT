package com.example.franquicias_api.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author LEO
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI franchiseOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Franquicias API")
                        .description("API para administrar franquicias, sucursales y productos")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("David Gomez")
                                .email("bojacasa@gmail.com"))
                        .license(new License()
                                .name("MIT License")))
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository"));
    }
}
