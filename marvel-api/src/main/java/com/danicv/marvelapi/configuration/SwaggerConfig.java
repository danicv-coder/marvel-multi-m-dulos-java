package com.danicv.marvelapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Author: Daniel Calderon
@Configuration
public class SwaggerConfig {
    private static final String TITULO = "Marvel-Api";
    private static final String DESCRIPTION = "Microservicio de character de Marvel";
    private static final String VERSION = "1.0";
    private static final String NAME = "Daniel Calderon";
    private static final String EMAIL = "daniel.calderon.e.v@gmail.com";
    private static final String URL = "https://github.com/danicv-coder";

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(TITULO)
                        .description(DESCRIPTION)
                        .version(VERSION)
                        .contact(new Contact().name(NAME).email(EMAIL).url(URL)));
    }
}
