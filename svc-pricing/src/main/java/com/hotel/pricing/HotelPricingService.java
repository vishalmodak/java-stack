package com.hotel.pricing;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.hotel.rate.proto.Availability;
import com.hotel.rate.proto.HotelPricePreview;

@Service
public class HotelPricingService {
    private Random randomGenerator;
    private long delay = 0;
    private boolean enableFailures;
    
    public HotelPricingService() {
        randomGenerator = new Random();
    }

    public HotelPricePreview getHotelPricing(int hotelId) throws Exception {
        Thread.sleep(delay);
        Double price = 100 + (1000 - 100) * randomGenerator.nextDouble();
        if (enableFailures && price > 900) {
            throw new Exception("Fake Exception");
        }
        return HotelPricePreview.newBuilder()
                                .setHotelId(hotelId)
                                .setAvailabilityStatus(Availability.AVAILABLE)
                                .setDisplayPrice(price.doubleValue())
                                .build();
    }
    
    public void setDelay(long delay) {
        this.delay = delay;
        System.out.println("Delay (in secs) = " + (this.delay/1000));
    }
    
    public void toggleFailures() {
        this.enableFailures = this.enableFailures ? false : true;
    }
}
