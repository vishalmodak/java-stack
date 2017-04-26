package com.hotel.rating;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.hotel.reviews.proto.HotelReviewInfo;

@Service
public class HotelRatingService {
    
    private Random randomGenerator = new Random();
        
    public HotelReviewInfo getHotelRating(int hotelId) throws Exception {
        Double rating = 0d + (5d - 0d) * randomGenerator.nextDouble();
        return HotelReviewInfo.newBuilder().setHotelId(hotelId).setHotelReviewRating(rating).build();
    }
    
}
