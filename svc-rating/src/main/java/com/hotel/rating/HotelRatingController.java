package com.hotel.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.reviews.proto.HotelReviewInfo;

@RestController
public class HotelRatingController {

    private HotelRatingService service;
    
    @Autowired
    public HotelRatingController(HotelRatingService service) {
        this.service = service;
    }
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Rating Service!";
    }
    
    @RequestMapping(value="/hotel/rating/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    public HotelReviewInfo getHotelRating(@PathVariable int hotelId) throws Exception {
        return service.getHotelRating(hotelId);
    }
}
