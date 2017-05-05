package com.hotel.aggregator.callable;

import java.util.concurrent.Callable;

import com.google.protobuf.GeneratedMessageV3;
import com.hotel.aggregator.clients.HotelRatingClient;
import com.hotel.reviews.proto.HotelReviewInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


public class ReviewsCallable implements Callable<GeneratedMessageV3> {
    private String hotelId;
    
    private HotelRatingClient hotelRatingClient;
    
    public ReviewsCallable(HotelRatingClient hotelRatingClient, String hotelId) { 
        this.hotelRatingClient = hotelRatingClient;
        this.hotelId = hotelId;
    }
    
    @Override
    public HotelReviewInfo call() throws Exception {
        return getHotelRatings(hotelId);
    }
    
    @HystrixCommand(fallbackMethod = "defaultRating")
    public HotelReviewInfo getHotelRatings(final String hotelId) {
        return hotelRatingClient.getHotelRating(hotelId);
    }

    public HotelReviewInfo defaultRating() {
        return HotelReviewInfo.getDefaultInstance();
    }
}