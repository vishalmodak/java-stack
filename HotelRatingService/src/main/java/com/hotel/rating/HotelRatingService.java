package com.hotel.rating;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class HotelRatingService {
    private Random randomGenerator;
    
    public HotelRatingService() {
        randomGenerator = new Random();
    }
        
    //@HystrixCommand(fallbackMethod = "defaultRating")
    public String getHotelRating(String productId) throws Exception {
        int rating = randomGenerator.nextInt(7);
//        if (rating == 6) {
//            System.out.println("=================FAILURE===================");
//            throw new Exception();
//        }
        return String.valueOf(rating);
    }
    
    public Object defaultRating(String hotelId) {
        return "0";
    }
}
