package com.github.lenaHelen17.boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
//https://sabljakovich.medium.com/adding-basic-auth-authorization-option-to-openapi-swagger-documentation-java-spring-95abbede27e9
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(
                title = "REST API documentation",
                version = "1.0",
                description = """
                        Spring Boot приложение 
                        <p><b>Тестовые креденшелы:</b><br>
                        - user@gmail.com/ password<br>
                        - admin@mail.ru/ admin</p>
                        """
        ),
        security = @SecurityRequirement(name = "basicAuth")
)

public class OpenApiConfig {
    static {
        var schema = new Schema<LocalDate>();
        schema.example(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        SpringDocUtils.getConfig().replaceWithSchema(LocalDate.class, schema);
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("REST API")
                .pathsToMatch("/api/**")
                .pathsToExclude("/api/profile/**")
                .build();
    }
}
