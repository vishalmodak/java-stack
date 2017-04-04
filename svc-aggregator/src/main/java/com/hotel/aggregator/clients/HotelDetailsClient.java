package com.hotel.aggregator.clients;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("svc-details")
public interface HotelDetailsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/details/{hotelId}")
    @Cacheable("details")
    String getHotelDetails(@PathVariable("hotelId") String hotelId);
    
}
