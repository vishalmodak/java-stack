package com.hotel.avail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@ComponentScan("com.hotel")
public class HotelAvailabilityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAvailabilityServiceApplication.class, args);
    }
    
    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
}
