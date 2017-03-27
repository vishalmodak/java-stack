package com.hotel.aggregator.callable;

import java.util.concurrent.Callable;

import com.hotel.aggregator.AsyncResponse;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class DetailsCallable implements Callable<AsyncResponse>{
    private String hotelId;

    private HotelDetailsClient hotelDetailsClient;

    public DetailsCallable(HotelDetailsClient hotelDetailsClient, String hotelId) { 
        this.hotelDetailsClient = hotelDetailsClient;
        this.hotelId = hotelId;
    }
    
    @Override
    public AsyncResponse call() throws Exception {
        return new AsyncResponse("details", getHotelDetails(this.hotelId));
    }
    @HystrixCommand(fallbackMethod = "defaultDetails")
    public String getHotelDetails(final String hotelId) {
        return hotelDetailsClient.getHotelDetails(hotelId);
    }
    public String defaultDetails() {
        return "DEFAULT";
    }
}