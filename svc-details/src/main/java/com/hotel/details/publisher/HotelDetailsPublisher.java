package com.hotel.details.publisher;

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
import com.hotel.details.RandomHotelGenerator;
import com.hotel.proto.HotelDetails;

@Component
public class HotelDetailsPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(HotelDetailsPublisher.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaSender;
    
    @Autowired
    private RandomHotelGenerator hotelGenerator;

    
    @Scheduled(fixedRate = 5000)
    public void publishUpdate() throws Exception {
        try {
            Long hotelId = Long.valueOf(RandomUtils.nextInt(100));
            HotelDetails details = hotelGenerator.build(hotelId);
            ListenableFuture<SendResult<String, String>> future = kafkaSender.sendDefault(hotelId.toString(), JsonFormat.printer().print(details));

            // register a callback with the listener to receive the result of the send asynchronously
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

              @Override
              public void onSuccess(SendResult<String, String> result) {
                LOG.info("sent update for hotel='{}'", details.getHotelId());
              }

              @Override
              public void onFailure(Throwable ex) {
                LOG.error("failed update for hotel='{}'", details.getHotelId(), ex);
              }
            });
        } catch (Exception e) {
            LOG.error("Failure publishing to topic due to ", e);
        }
    }
}
