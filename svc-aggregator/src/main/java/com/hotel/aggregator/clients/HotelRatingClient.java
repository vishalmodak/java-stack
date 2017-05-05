package com.hotel.aggregator.clients;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotel.reviews.proto.HotelReviewInfo;

@FeignClient("svc-rating")
public interface HotelRatingClient {

    @RequestMapping(method = RequestMethod.GET, value = "/rating/{hotelId}", consumes={"application/x-protobuf"})
    @Cacheable("ratings")
    HotelReviewInfo getHotelRating(@PathVariable("hotelId") String hotelId);
    
}
