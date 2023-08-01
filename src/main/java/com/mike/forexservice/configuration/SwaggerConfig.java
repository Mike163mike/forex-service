package com.mike.forexservice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Forex Service API")
                        .version("1.0.0")
                        .description("App for getting actual information about currency value.")
                        .contact(
                                new Contact()
                                        .email("mick_mick_mick@icloud.com")
                                        .name("Mike")));
    }
}
