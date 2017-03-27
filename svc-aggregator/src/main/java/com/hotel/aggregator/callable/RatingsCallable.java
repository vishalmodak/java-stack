package com.hotel.aggregator.callable;

import java.util.concurrent.Callable;

import com.hotel.aggregator.AsyncResponse;
import com.hotel.aggregator.clients.HotelRatingClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


public class RatingsCallable implements Callable<AsyncResponse> {
    private String hotelId;
    
    private HotelRatingClient hotelRatingClient;
    
    public RatingsCallable(HotelRatingClient hotelRatingClient, String hotelId) { 
        this.hotelRatingClient = hotelRatingClient;
        this.hotelId = hotelId;
    }
    
    @Override
    public AsyncResponse call() throws Exception {
        return new AsyncResponse("rating", getHotelRatings(hotelId));
    }
    
    @HystrixCommand(fallbackMethod = "defaultRating")
    public String getHotelRatings(final String hotelId) {
        return hotelRatingClient.getHotelRating(hotelId);
    }

    public String defaultRating() {
        return "0";
    }
}