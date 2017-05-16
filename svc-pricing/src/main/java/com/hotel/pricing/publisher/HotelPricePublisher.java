package com.hotel.pricing.publisher;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.google.protobuf.util.JsonFormat;
import com.hotel.pricing.RandomPriceGenerator;
import com.hotel.rate.proto.HotelPricePreview;

@Component
public class HotelPricePublisher {
    private static final Logger LOG = LoggerFactory.getLogger(HotelPricePublisher.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaSender;
    
    @Autowired
    private RandomPriceGenerator priceGenerator;

    
    @Scheduled(fixedRate = 5000)
    public void publishUpdate() throws Exception {
        try {
            Long hotelId = Long.valueOf(RandomUtils.nextInt(100));
            HotelPricePreview pricePreview = priceGenerator.build(hotelId);
            ListenableFuture<SendResult<String, String>> future = kafkaSender.sendDefault(JsonFormat.printer().print(pricePreview));

            // register a callback with the listener to receive the result of the send asynchronously
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

              @Override
              public void onSuccess(SendResult<String, String> result) {
                LOG.info("sent price update for hotel='{}'", pricePreview.getHotelId());
              }

              @Override
              public void onFailure(Throwable ex) {
                LOG.error("failed price update for hotel='{}'", pricePreview.getHotelId(), ex);
              }
            });
        } catch (Exception e) {
            LOG.error("Failure publishing to topic due to ", e);
        }
    }
}
