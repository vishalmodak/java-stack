package com.hotel.avail;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelAvailabilityService {
    
    @Autowired
    private HotelPricingClient pricingClient;
    
    public HotelPricingInfo getHotelAvailability(String hotelId) throws Exception {
        Double price = pricingClient.getHotelPrice(hotelId);
        if (price.equals(Double.valueOf(0))) {
            return new HotelPricingInfo(hotelId, 0.0, "UNAVAILABLE", 0);
        }
        return new HotelPricingInfo(hotelId, price, "AVAILABLE", RandomUtils.nextInt(20));
    }
    
}
