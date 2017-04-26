package com.hotel.avail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.rate.proto.HotelPricePreview;

@Service
public class HotelAvailabilityService {
    
    @Autowired
    private HotelPricingClient pricingClient;
    
    public HotelPricePreview getHotelAvailability(String hotelId) throws Exception {
        return pricingClient.getHotelPrice(hotelId);
    }
    
}
