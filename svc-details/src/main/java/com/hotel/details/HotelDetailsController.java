package com.hotel.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.proto.HotelDetails;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@EnableDiscoveryClient
@RestController
@Api(value = "hoteldetails")
public class HotelDetailsController {

    @Autowired
    private HotelDetailService service;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Details Service! ";
    }
    
    @RequestMapping(value="/hotel/details/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hotel Name")
    public HotelDetails getHotelDetails(@PathVariable String hotelId) throws Exception {
        return service.getHotelDetails(hotelId);
    }

}
