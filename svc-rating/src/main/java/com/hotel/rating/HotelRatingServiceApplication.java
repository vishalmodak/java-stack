package com.hotel.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class HotelRatingServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(HotelRatingServiceApplication.class, args);
    }
}
