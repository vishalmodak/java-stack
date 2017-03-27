package com.hotel.aggregator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableSwagger2
@Api(value = "hotelGateway", description = "HotelGateway API")
public class HotelAggregatorApplication {
    @Autowired
    private HotelAggregatorService aggregator;
    
    @Autowired
    private HotelAggregatorService2 aggregator2;

    public static void main(String[] args) {
        SpringApplication.run(HotelAggregatorApplication.class, args);
    }
    
    @RequestMapping(value="/summary/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelSummary", notes = "Returns Hotel Name & Price")
    public String getHotelSummary(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson(); 
        String json = gson.toJson(aggregator.getHotelSummary(hotelId)); 
        return json;
    }

    @RequestMapping(value="/infoX/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hote Name, Price, Reviews & Rating")
    public String getHotelInfoAsync(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(aggregator2.getHotelData(hotelId));
        return json;
    }
    
    @RequestMapping(value="/infoY/{hotelId}", method = RequestMethod.GET)
    @ApiOperation(value = "getHotelDetails", notes = "Returns Hote Name, Price, Reviews & Rating")
    public String getHotelInfoSync(@PathVariable String hotelId) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(aggregator.getHotelInfo(hotelId));
        return json;
    }
}
