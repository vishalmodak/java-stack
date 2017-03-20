package com.hotel.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "hotelPricing", description = "HotelPricing API")
public class HotelPricingController {

    @Autowired
    private HotelPricingService service;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Pricing Service! ";
    }
    
    @RequestMapping(value="/hotel/pricing/{hotelId}", method=RequestMethod.GET)
    @ApiOperation(value = "getHotelPricing", notes = "Returns the price & availability for a given hotel")
    public Double getHotelAvailability(@PathVariable String hotelId) throws Exception {
        return service.getHotelPricing(hotelId);
    }
    
    @RequestMapping(value="/hotel/pricing/delay/{delay}", method=RequestMethod.POST)
    @ApiOperation(value = "setDelay", notes = "Sets the latency delay")
    public void setDelay(@PathVariable String delay) throws Exception {
        service.setDelay(Long.parseLong(delay));
    }
    
    @RequestMapping(value="/hotel/pricing/toggleFailures", method=RequestMethod.POST)
    @ApiOperation(value = "toggleFailures", notes = "Enables/Disables failures in the service")
    public void toggleFailures() throws Exception {
        service.toggleFailures();
    }
}
