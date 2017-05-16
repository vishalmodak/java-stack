package com.hotel.rating.publisher;

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
import com.hotel.rating.RandomRatingReviewGenerator;
import com.hotel.reviews.proto.HotelReviewInfo;

@Component
public class HotelReviewsPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(HotelReviewsPublisher.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaSender;
    
    @Autowired
    private RandomRatingReviewGenerator reviewsGenerator;

    
    @Scheduled(fixedRate = 5000)
    public void publishUpdate() throws Exception {
        try {
            Long hotelId = Long.valueOf(RandomUtils.nextInt(100));
            int numReviews = RandomUtils.nextInt(10);
            HotelReviewInfo reviewInfo = reviewsGenerator.build(hotelId, numReviews, false);
            ListenableFuture<SendResult<String, String>> future = kafkaSender.sendDefault(JsonFormat.printer().print(reviewInfo));

            // register a callback with the listener to receive the result of the send asynchronously
            future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

              @Override
              public void onSuccess(SendResult<String, String> result) {
                LOG.info("sent reviews update for hotel='{}'", reviewInfo.getHotelId());
              }

              @Override
              public void onFailure(Throwable ex) {
                LOG.error("failed reviews update for hotel='{}'", reviewInfo.getHotelId(), ex);
              }
            });
        } catch (Exception e) {
            LOG.error("Failure publishing to topic due to ", e);
        }
    }
}
