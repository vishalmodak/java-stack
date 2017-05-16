package com.hotel.rating;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.reviews.proto.HotelReviewInfo;

@Service
public class HotelReviewsService {
    
    @Autowired
    private RandomRatingReviewGenerator randomReviewGenerator;
    
    private Random numReviewsRandom = new Random();
    private Random latencyDelay = new Random();
        
    public HotelReviewInfo getHotelRating(Long hotelId, boolean partial) throws Exception {
        Thread.sleep(latencyDelay.nextInt(5000));
        return randomReviewGenerator.build(hotelId, numReviewsRandom.nextInt(10), partial);
    }
    
}
