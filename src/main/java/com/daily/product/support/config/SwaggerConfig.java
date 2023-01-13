package com.daily.product.support.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String TITLE = "Daily Product FAQ";
    private static final String DESCRIPTION = "실제 연동은 8000 포트를 통해 연동한다. (http://url:8000/endpoint)";
    private static final String VERSION = "1.0.0";

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("v1-definition")
            .pathsToMatch("/**")
            .build();
    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
            .info(new Info().title(TITLE)
            .description(DESCRIPTION)
            .version(VERSION));
    }
}
