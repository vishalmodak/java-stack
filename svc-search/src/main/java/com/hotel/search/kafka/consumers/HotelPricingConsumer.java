package com.hotel.search.kafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.model.HotelPricePreview;

//@Component
public class HotelPricingConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(HotelPricingConsumer.class);
    
    @KafkaListener(topics = "hotel-price")
    public void getPrice(String data) {
        ObjectMapper mapper = new ObjectMapper();
        HotelPricePreview pricePreview;
        try {
            pricePreview = mapper.readValue(data, HotelPricePreview.class);
            LOG.info(pricePreview.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
