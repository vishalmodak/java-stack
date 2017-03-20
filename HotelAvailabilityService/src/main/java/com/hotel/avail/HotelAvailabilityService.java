package com.hotel.avail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HotelAvailabilityService {
    
    @Autowired
    private HotelPricingClient pricingClient;

    public HotelAvailabilityService() {

    }
    
    @HystrixCommand()
    public HotelPricingInfo getHotelAvailability(String hotelId) throws Exception {
        Double price = pricingClient.getHotelPrice(hotelId);
        if (price.equals(Double.valueOf(0))) {
            return new HotelPricingInfo(hotelId, 0.0, "UNAVAILABLE");
        }
        return new HotelPricingInfo(hotelId, price, "AVAILABLE");
    }
    
//    public Object defaultAvailability(String hotelId) {
//        return new HotelPricingInfo(hotelId, null, "UNKNOWN");
//    }
    
}
