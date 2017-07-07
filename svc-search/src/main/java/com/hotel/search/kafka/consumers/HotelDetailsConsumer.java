package com.hotel.search.kafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.model.HotelDetails;

//@Component
public class HotelDetailsConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(HotelDetailsConsumer.class);
    
    @KafkaListener(topics = "hotel-details")
    public void getHotelDetails(String data) {
        ObjectMapper mapper = new ObjectMapper();
        HotelDetails hotelDetails;
        try {
            hotelDetails = mapper.readValue(data, HotelDetails.class);
            LOG.info(hotelDetails.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
