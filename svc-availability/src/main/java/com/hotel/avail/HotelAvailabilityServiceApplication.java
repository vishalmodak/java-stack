package com.hotel.avail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableFeignClients
public class HotelAvailabilityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelAvailabilityServiceApplication.class, args);
    }
}
