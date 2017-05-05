package com.hotel.aggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.GeneratedMessageV3;
import com.hotel.aggregator.callable.AvailabilityCallable;
import com.hotel.aggregator.callable.DetailsCallable;
import com.hotel.aggregator.callable.ReviewsCallable;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.aggregator.clients.HotelRatingClient;
import com.hotel.proto.HotelDetails;
import com.hotel.rate.proto.HotelPricePreview;
import com.hotel.reviews.proto.HotelReviewInfo;
import com.hotel.shop.proto.HotelShoppingInfo;

@Service
public class HotelAggregatorService2 {

    private static final int TIMEOUT = 2000;
    
    @Autowired
    private HotelDetailsClient hotelDetailsClient;

    @Autowired
    private HotelRatingClient hotelRatingClient;
    
    @Autowired
    private HotelAvailabilityClient hotelAvailabilityClient;

    public HotelShoppingInfo getHotelData(String hotelId) throws InterruptedException {
        List<Callable<GeneratedMessageV3>> callables = new ArrayList<>();
        callables.add(new DetailsCallable(hotelDetailsClient, hotelId));
        callables.add(new ReviewsCallable(hotelRatingClient, hotelId));
        callables.add(new AvailabilityCallable(hotelAvailabilityClient, hotelId));
        return doBackendAsyncServiceCall(callables);
    }
    
    private HotelShoppingInfo doBackendAsyncServiceCall(List<Callable<GeneratedMessageV3>> callables) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<GeneratedMessageV3>> futures = executorService.invokeAll(callables);
        executorService.shutdown();
        executorService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS);
        HotelShoppingInfo.Builder shoppingInfoBuilder = HotelShoppingInfo.newBuilder();
        futures.forEach(future ->  {
            try {
                GeneratedMessageV3 proto = future.get();
                if (proto.getClass().equals(HotelDetails.class)) {
                    shoppingInfoBuilder.setHotelDetails((HotelDetails)proto);
                } else if (proto.getClass().equals(HotelPricePreview.class)) {
                    shoppingInfoBuilder.setPricePreview((HotelPricePreview)proto);
                } else if (proto.getClass().equals(HotelReviewInfo.class)) {
                    shoppingInfoBuilder.setReviewInfo((HotelReviewInfo)proto);
                }
            } catch (InterruptedException|ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return shoppingInfoBuilder.build();

    }
    
}
