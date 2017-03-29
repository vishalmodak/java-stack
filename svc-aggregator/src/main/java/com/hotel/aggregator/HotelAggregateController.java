package com.hotel.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Hotel Aggregator")
public class HotelAggregateController {
    @Autowired
    private HotelAggregatorService aggregator;
    
    @Autowired
    private HotelAggregatorService2 aggregator2;
    
    @RequestMapping(value="/summary/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelSummary", notes = "Returns Hotel Name & Price")
    public String getHotelSummary(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson(); 
        String json = gson.toJson(aggregator.getHotelSummary(hotelId)); 
        return json;
    }

    @RequestMapping(value="/infoX/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hotel Name, Price, Reviews & Rating")
    public String getHotelInfoAsync(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(aggregator2.getHotelData(hotelId));
        return json;
    }
    
    @RequestMapping(value="/infoY/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hotel Name, Price, Reviews & Rating")
    public String getHotelInfoSync(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(aggregator.getHotelInfo(hotelId));
        return json;
    }
}
