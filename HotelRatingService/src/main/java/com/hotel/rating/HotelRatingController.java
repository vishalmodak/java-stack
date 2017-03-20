package com.hotel.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value="/hotel/rating/{hotelId}", method=RequestMethod.GET)
    public String getHotelRating(@PathVariable String hotelId) throws Exception {
        return service.getHotelRating(hotelId);
    }
}
