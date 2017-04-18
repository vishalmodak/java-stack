package com.hotel.aggregator;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.aggregator.clients.HotelRatingClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HotelSyncAggregatorService {
    private static final Logger LOG = LoggerFactory.getLogger(HotelSyncAggregatorService.class);

    private static final String DETAILS_GROUP = "details";
    private static final String RATING_GROUP = "rating";
    private static final String AVAIL_GROUP = "avail";
    
    @Autowired
    private HotelDetailsClient hotelDetailsClient;

    @Autowired
    private HotelRatingClient hotelRatingClient;
    
    @Autowired
    private HotelAvailabilityClient hotelAvailabilityClient;

    public Map<String, String> getHotelData(String hotelId) {
        Map<String, String> result = new HashMap<>();
        result.put(DETAILS_GROUP, getHotelDetails(hotelId));
        result.put(RATING_GROUP, getHotelRatings(hotelId));
        result.put(AVAIL_GROUP, getHotelAvailability(hotelId));
        return result;
    }
    

    @HystrixCommand(fallbackMethod = "defaultRating")
    public String getHotelRatings(final String hotelId) {
        LOG.info("getHotelRatings() invoked....");
        return hotelRatingClient.getHotelRating(hotelId);
    }

    public String defaultRating() {
        return "0";
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


    @HystrixCommand(fallbackMethod = "defaultDetails")
    public String getHotelDetails(final String hotelId) {
        return hotelDetailsClient.getHotelDetails(hotelId).toString();
    }
    
    public String defaultDetails() {
        return "DEFAULT";
    }
    
}
