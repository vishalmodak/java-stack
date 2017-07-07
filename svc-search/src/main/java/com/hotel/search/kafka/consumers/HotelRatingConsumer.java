package com.hotel.search.kafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.model.HotelReviewInfo;

//@Component
public class HotelRatingConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(HotelRatingConsumer.class);
    
    @KafkaListener(topics = "hotel-reviews")
    public void getReviews(String data) {
        ObjectMapper mapper = new ObjectMapper();
        HotelReviewInfo reviewInfo;
        try {
//            LOG.info("HEADERS: {}, {}, {}", key, partition, offsets.toString());
            reviewInfo = mapper.readValue(data, HotelReviewInfo.class);
            LOG.info(reviewInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
