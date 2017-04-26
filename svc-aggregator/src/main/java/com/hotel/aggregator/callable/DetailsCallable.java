package com.hotel.aggregator.callable;

import java.util.concurrent.Callable;

import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.proto.HotelDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class DetailsCallable implements Callable<HotelDetails>{
    private String hotelId;

    private HotelDetailsClient hotelDetailsClient;

    public DetailsCallable(HotelDetailsClient hotelDetailsClient, String hotelId) { 
        this.hotelDetailsClient = hotelDetailsClient;
        this.hotelId = hotelId;
    }
    
    @Override
    public HotelDetails call() throws Exception {
        return getHotelDetails(this.hotelId);
    }
    @HystrixCommand(fallbackMethod = "defaultDetails")
    public HotelDetails getHotelDetails(final String hotelId) {
        return hotelDetailsClient.getHotelDetails(hotelId);
    }
    public HotelDetails defaultDetails() {
        return HotelDetails.getDefaultInstance();
    }
}