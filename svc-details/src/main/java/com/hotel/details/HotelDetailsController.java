package com.hotel.details;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.proto.HotelDetails;
import com.hotel.proto.HotelsList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@EnableDiscoveryClient
@RestController
@Api(value = "hoteldetails")
public class HotelDetailsController {
    
    private static final Logger LOG = LoggerFactory.getLogger(HotelDetailsController.class);

    @Autowired
    private HotelDetailService service;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Details Service! ";
    }
    
    @RequestMapping(value="/hotel/details/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hotel Name")
    public HotelDetails getHotelDetails(@PathVariable long hotelId) throws Exception {
        return service.getHotelDetails(hotelId);
    }

    @RequestMapping(value="/hotel/list", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    @ApiOperation(value = "getHotelList", notes = "Returns Hotel Name")
    public HotelsList getHotelList(@RequestParam(name="pageSize", required=false, defaultValue="5") int pageSize) {
//        if (pageSize == 0) {
//            pageSize=5;
//        }
        try {
            return service.getHotelList(pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return HotelsList.getDefaultInstance();
    }
}
