package com.hotel.pricing;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.rate.proto.HotelPricePreview;

@Service
public class HotelPricingService {

    private static final Logger LOG = LoggerFactory.getLogger(HotelPricingService.class);

    @Autowired
    private RandomPriceGenerator priceGenerator;

    private Random latencyDelay = new Random();
    private boolean enableFailures;
    

    public HotelPricePreview getHotelPricing(Long hotelId) throws Exception {
        Thread.sleep(latencyDelay.nextInt(5000));
        HotelPricePreview price = priceGenerator.build(hotelId);
        if (enableFailures && price.getDisplayPrice() > 900) {
            throw new Exception("Fake Exception");
        }
        return price;
    }

}
