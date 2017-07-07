package com.hotel.streams.processor;

import org.apache.kafka.streams.processor.AbstractProcessor;

import com.hotel.model.HotelReviewInfo;

public class HotelAggregator extends AbstractProcessor<String, HotelReviewInfo>{

    @Override
    public void process(String key, HotelReviewInfo value) {
        // TODO Auto-generated method stub
        
    }

}
