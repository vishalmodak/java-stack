package com.hotel.aggregator.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.rate.proto.HotelPricePreview;


@FeignClient("svc-pricing")
public interface HotelPricingClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pricing/partial/{hotelId}", consumes={"application/x-protobuf"})
    HotelPricePreview getHotelPrice(@PathVariable("hotelId") String hotelId);
}
