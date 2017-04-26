package com.hotel.aggregator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.aggregator.clients.HotelRatingClient;
import com.hotel.proto.HotelDetails;
import com.hotel.rate.proto.HotelPricePreview;
import com.hotel.reviews.proto.HotelReviewInfo;
import com.hotel.shop.proto.HotelShoppingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HotelSyncAggregatorService {
    private static final Logger LOG = LoggerFactory.getLogger(HotelSyncAggregatorService.class);
    
    @Autowired
    private HotelDetailsClient hotelDetailsClient;

    @Autowired
    private HotelRatingClient hotelRatingClient;
    
    @Autowired
    private HotelAvailabilityClient hotelAvailabilityClient;

    public HotelShoppingInfo getHotelData(String hotelId) throws Exception {
        HotelShoppingInfo.Builder shoppingInfoBuilder = HotelShoppingInfo.newBuilder();
        shoppingInfoBuilder.setHotelDetails(getHotelDetails(hotelId));
        shoppingInfoBuilder.setReviewInfo(getHotelReviews(hotelId));
        shoppingInfoBuilder.setPricePreview(getHotelAvailability(hotelId));
        return shoppingInfoBuilder.build();
    }
    

    @HystrixCommand(fallbackMethod = "defaultReviews")
    public HotelReviewInfo getHotelReviews(final String hotelId) throws Exception {
        LOG.info("getHotelRatings() invoked....");
        return hotelRatingClient.getHotelRating(hotelId);
    }

    public HotelReviewInfo defaultReviews() {
        return HotelReviewInfo.getDefaultInstance();
    }
    
    @HystrixCommand(fallbackMethod = "defaultAvailability")
    public HotelPricePreview getHotelAvailability(final String hotelId) throws Exception {
        return hotelAvailabilityClient.getHotelAvailability(hotelId);
    }
    public HotelPricePreview defaultAvailability() {
        return HotelPricePreview.getDefaultInstance();
    }


    @HystrixCommand(fallbackMethod = "defaultDetails")
    public HotelDetails getHotelDetails(final String hotelId) throws Exception {
        return hotelDetailsClient.getHotelDetails(hotelId);
    }
    
    public HotelDetails defaultDetails() {
        return HotelDetails.getDefaultInstance();
    }
    
}
