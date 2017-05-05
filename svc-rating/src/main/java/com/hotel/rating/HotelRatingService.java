package com.hotel.rating;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reviews.proto.HotelReviewInfo;

@Service
public class HotelRatingService {
    
    @Autowired
    private RandomRatingReviewGenerator randomReviewGenerator;
    
    private Random numReviewsRandom = new Random();
        
    public HotelReviewInfo getHotelRating(Long hotelId, boolean partial) throws Exception {
        return randomReviewGenerator.build(hotelId, numReviewsRandom.nextInt(10), partial);
    }
    
}
