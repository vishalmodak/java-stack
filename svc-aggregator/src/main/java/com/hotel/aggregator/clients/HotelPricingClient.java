package com.hotel.aggregator.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("hotelpricing")
public interface HotelPricingClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hotel/pricing/{hotelId}")
    Double getHotelPrice(@PathVariable("hotelId") String hotelId);
}
