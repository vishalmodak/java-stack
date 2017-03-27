package com.hotel.aggregator.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("hotelrating")
public interface HotelRatingClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/rating/{hotelId}")
    String getHotelRating(@PathVariable("hotelId") String hotelId);
    
}
