package com.hotel.aggregator.callable;

import java.util.concurrent.Callable;

import com.google.protobuf.GeneratedMessageV3;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.rate.proto.HotelPricePreview;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class AvailabilityCallable implements Callable<GeneratedMessageV3> {
    private String hotelId;
    
    private HotelAvailabilityClient hotelAvailabilityClient;
    
    public AvailabilityCallable(HotelAvailabilityClient hotelAvailabilityClient, String hotelId) { 
        this.hotelAvailabilityClient = hotelAvailabilityClient;
        this.hotelId = hotelId;
    }
    
    @Override
    public HotelPricePreview call() throws Exception {
        return getHotelAvailability(hotelId);
    }
    
    @HystrixCommand(fallbackMethod = "defaultAvailability")
    public HotelPricePreview getHotelAvailability(final String hotelId) {
        return hotelAvailabilityClient.getHotelAvailability(hotelId);
    }
    public HotelPricePreview defaultAvailability() {
        return HotelPricePreview.getDefaultInstance();
    }
}
