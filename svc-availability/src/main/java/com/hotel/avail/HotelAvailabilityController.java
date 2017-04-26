package com.hotel.avail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.rate.proto.HotelPricePreview;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@EnableDiscoveryClient
@RestController
@Api(value = "hotelAvailability")
public class HotelAvailabilityController {

    @Autowired
    private HotelAvailabilityService service;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Availability Service! ";
    }
    
    @RequestMapping(value="/hotel/avail/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    @ApiOperation(value = "getHotelAvailability", notes = "Returns the price & availability for a given hotel")
    public HotelPricePreview getHotelAvailability(@PathVariable String hotelId) throws Exception {
        return service.getHotelAvailability(hotelId);
    }
    
}
