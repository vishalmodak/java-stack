package com.hotel.search.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(endpoints())
                .build();
        return docket;
    }
    
    private Predicate<String> endpoints() {
        return regex("/hotel/.*");
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("HotelDetails API")
                .build();
    }
}
