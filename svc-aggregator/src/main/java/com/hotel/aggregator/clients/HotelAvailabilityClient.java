package com.hotel.aggregator.clients;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.aggregator.config.CacheConfig;
import com.hotel.rate.proto.HotelPricePreview;

@FeignClient("svc-availability")
public interface HotelAvailabilityClient {

    @RequestMapping(value="/hotel/avail/{hotelId}", method=RequestMethod.GET, consumes={"application/x-protobuf"})
    @Cacheable(CacheConfig.CACHE_AVAILABILITY)
    public HotelPricePreview getHotelAvailability(@PathVariable("hotelId") String hotelId);
}
