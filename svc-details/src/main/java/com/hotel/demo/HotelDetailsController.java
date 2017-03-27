package com.hotel.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@EnableDiscoveryClient
@RestController
@Api(value = "hoteldetails", description = "HotelDetails API")
public class HotelDetailsController {

//    @Autowired
//    private DiscoveryClient client;
    @Autowired
    private HotelDetailService service;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Details Service! ";
    }
    
    @RequestMapping(value="/hotel/details/{hotelId}", method=RequestMethod.GET)
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hotel Name")
    public String getHotelDetails(@PathVariable String hotelId) throws Exception {
        return service.getHotelDetails(hotelId);
    }
    
    @RequestMapping(value="/hotel/details/delay/{delay}", method=RequestMethod.POST)
    @ApiOperation(value = "setDelay", notes = "Sets the latency delay")
    public void setDelay(@PathVariable String delay) throws Exception {
        service.setDelay(Long.parseLong(delay));
    }
    
    @RequestMapping(value="/hotel/hotel/toggleFailures", method=RequestMethod.POST)
    @ApiOperation(value = "toggleFailures", notes = "Enables/Disables failures in the service")
    public void toggleFailures() throws Exception {
        service.toggleFailures();
    }
}
