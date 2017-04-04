package com.hotel.aggregator.clients;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.aggregator.config.CacheConfig;

@FeignClient("svc-availability")
public interface HotelAvailabilityClient {

    @RequestMapping(value="/hotel/avail/{hotelId}", method=RequestMethod.GET)
    @Cacheable(CacheConfig.CACHE_AVAILABILITY)
    public String getHotelAvailability(@PathVariable("hotelId") String hotelId);
}
