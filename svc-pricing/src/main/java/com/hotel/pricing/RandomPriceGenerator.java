package com.hotel.pricing;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.hotel.rate.proto.Availability;
import com.hotel.rate.proto.HotelPricePreview;

@Component
public class RandomPriceGenerator {

    private Random randomGenerator = new Random();
    
    public HotelPricePreview build(Long hotelId) {
        
        Double price = 100 + (1000 - 100) * randomGenerator.nextDouble();
        return HotelPricePreview.newBuilder()
                .setHotelId(hotelId)
                .setAvailabilityStatus(Availability.AVAILABLE)
                .setDisplayPrice(price.doubleValue())
                .build();

    }
}
