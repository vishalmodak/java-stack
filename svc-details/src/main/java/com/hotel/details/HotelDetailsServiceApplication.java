package com.hotel.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@SpringBootApplication
@EnableSwagger2
//@EnableAdminServer
public class HotelDetailsServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HotelDetailsServiceApplication.class, args);
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
}
