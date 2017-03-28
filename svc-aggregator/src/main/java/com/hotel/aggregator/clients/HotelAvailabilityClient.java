package com.hotel.aggregator.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("svc-availability")
public interface HotelAvailabilityClient {

    @RequestMapping(value="/hotel/avail/{hotelId}", method=RequestMethod.GET)
    public String getHotelAvailability(@PathVariable("hotelId") String hotelId);
}
