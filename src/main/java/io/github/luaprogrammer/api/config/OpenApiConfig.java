package io.github.luaprogrammer.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1")
                .packagesToScan( "io.github.luaprogrammer.api.controller" )
                .build();
    }

    @Bean
    public OpenAPI springOpenApi() {
        return new OpenAPI().info( info() );
    }

    private Info info() {
        return  new Info()
                .title( "Cadastro de usuário API" )
                .description( "Demonstração simples de um CRUD de cadastro" )
                .version( "1.0.0" );
    }

}
