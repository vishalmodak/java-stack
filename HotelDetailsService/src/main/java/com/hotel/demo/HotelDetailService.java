package com.hotel.demo;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HotelDetailService {
    
    private Random randomGenerator;
    private ArrayList<String> hotelDetailsList;
    private long delay = 0;
    private boolean enableFailures;
    
    
    public HotelDetailService() {
        randomGenerator = new Random();
        hotelDetailsList = new ArrayList<String>();
        hotelDetailsList.add("Grand Hyatt");
        hotelDetailsList.add("Park Hyatt");
        hotelDetailsList.add("Hyatt Regency");
        hotelDetailsList.add("Andaz");
        hotelDetailsList.add("Ziva");
        hotelDetailsList.add("Zilara");
    }
    
//UNCOMMENT the code below enable Hystrix fallback capability
//    @HystrixCommand(
//                fallbackMethod="defaultDetails",
//                commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//                },
//                threadPoolProperties = {
//                        @HystrixProperty(name = "coreSize", value = "5"),
//                        @HystrixProperty(name = "maxQueueSize", value = "2"),
//                        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "30000")
//                }
//    )
    public String getHotelDetails(String hotelId) throws Exception {
        int index = randomGenerator.nextInt(hotelDetailsList.size());
        if (enableFailures && index == 1) {
            throw new Exception("Dummy Exception");
        } else if (index == 2) {
            Thread.sleep(delay);
        }
        return hotelDetailsList.get(index);
    }
    
//    public Object defaultDetails(String hotelId) {
//        return "Hyatt";
//    }

    public void setDelay(long delay) {
        this.delay = delay;
        System.out.println("Delay (in secs) = " + (this.delay/1000));
    }
    
    public void toggleFailures() {
        this.enableFailures = this.enableFailures ? false : true;
    }
}
