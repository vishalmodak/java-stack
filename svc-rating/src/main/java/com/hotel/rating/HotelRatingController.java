package com.hotel.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.reviews.proto.HotelReviewInfo;

@RestController
public class HotelRatingController {

    private HotelReviewsService service;
    
    @Autowired
    public HotelRatingController(HotelReviewsService service) {
        this.service = service;
    }
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Hotel Rating Service!";
    }
    
    @RequestMapping(value="/rating/{hotelId}", method=RequestMethod.GET, produces={"application/json","application/x-protobuf"})
    public HotelReviewInfo getPartialReviews(@PathVariable Long hotelId,
                                            @RequestParam(name="partial", required=false, defaultValue="true") boolean partial) throws Exception {
        return service.getHotelRating(hotelId, partial);
    }
    
}
