package com.hotel.pricing;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class HotelPricingService {
    private Random randomGenerator;
    private long delay = 0;
    private boolean enableFailures;
    
    public HotelPricingService() {
        randomGenerator = new Random();
    }
    
//UNCOMMENT the code below enable Hystrix fallback capability
//    @HystrixCommand()
    public Double getHotelPricing(String hotelId) throws Exception {
        Thread.sleep(delay);
        Double price = 100 + (1000 - 100) * randomGenerator.nextDouble();
        if (enableFailures && price > 900) {
            throw new Exception("Fake Exception");
        }
        return price;
    }
    
//    public Object defaultPricing(String hotelId) {
//        return null;
//    }
    
    public void setDelay(long delay) {
        this.delay = delay;
        System.out.println("Delay (in secs) = " + (this.delay/1000));
    }
    
    public void toggleFailures() {
        this.enableFailures = this.enableFailures ? false : true;
    }
}
