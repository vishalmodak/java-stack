package com.hotel.aggregator.callable;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hotel.aggregator.AsyncResponse;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


public class AvailabilityCallable implements Callable<AsyncResponse> {
    private String hotelId;
    
    private HotelAvailabilityClient hotelAvailabilityClient;
    
    public AvailabilityCallable(HotelAvailabilityClient hotelAvailabilityClient, String hotelId) { 
        this.hotelAvailabilityClient = hotelAvailabilityClient;
        this.hotelId = hotelId;
    }
    
    @Override
    public AsyncResponse call() throws Exception {
        return new AsyncResponse("avail", getHotelAvailability(hotelId));
    }
    
    @HystrixCommand(fallbackMethod = "defaultAvailability")
    public String getHotelAvailability(final String hotelId) {
        Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        Map<String, String> map = new Gson().fromJson(hotelAvailabilityClient.getHotelAvailability(hotelId), type);
        return map.get("price") + ", " + map.get("availability");
    }
    public String defaultAvailability() {
        return "null, UNKNOWN";
    }
}
