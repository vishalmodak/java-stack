package com.hotel.pricing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.rate.proto.Availability;
import com.hotel.rate.proto.HotelPriceInfo;
import com.hotel.rate.proto.HotelPricePreview;
import com.hotel.rate.proto.RoomRate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "hotelPricing")
public class HotelPricingController {

    @Autowired
    private HotelPricingService service;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Pricing Service! ";
    }
    
    @RequestMapping(value="/pricing/partial/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    @ApiOperation(value = "getHotelPricing", notes = "Returns the price & availability for a given hotel")
    public HotelPricePreview getHotelPricePartial(@PathVariable long hotelId) throws Exception {
        return service.getHotelPricing(hotelId);
    }
    
    @RequestMapping(value="/pricing/full/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    @ApiOperation(value = "getHotelPricing", notes = "Returns the price & availability for a given hotel")
    public HotelPriceInfo getHotelPriceFull(@PathVariable int hotelId) throws Exception {
        return HotelPriceInfo.newBuilder()
                             .setHotelId(hotelId)
                             .setAvailabilityStatus(Availability.AVAILABLE)
                             .addRoomRates(RoomRate.newBuilder().buildPartial())
                             .build();
    }
}
