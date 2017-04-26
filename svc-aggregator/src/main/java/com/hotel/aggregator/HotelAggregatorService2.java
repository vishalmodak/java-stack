package com.hotel.aggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.GeneratedMessageV3;
import com.hotel.aggregator.callable.AvailabilityCallable;
import com.hotel.aggregator.callable.DetailsCallable;
import com.hotel.aggregator.callable.ReviewsCallable;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.aggregator.clients.HotelRatingClient;

@Service
public class HotelAggregatorService2 {

    private static final int TIMEOUT = 2000;
    
    @Autowired
    private HotelDetailsClient hotelDetailsClient;

    @Autowired
    private HotelRatingClient hotelRatingClient;
    
    @Autowired
    private HotelAvailabilityClient hotelAvailabilityClient;

    public Map<String, String> getHotelData(String hotelId) {
        List<Callable<? extends GeneratedMessageV3>> callables = new ArrayList<>();
        callables.add(new DetailsCallable(hotelDetailsClient, hotelId));
        callables.add(new ReviewsCallable(hotelRatingClient, hotelId));
        callables.add(new AvailabilityCallable(hotelAvailabilityClient, hotelId));
        return doBackendAsyncServiceCall(callables);
    }
    
    private Map<String, String> doBackendAsyncServiceCall(List<Callable<? extends GeneratedMessageV3>> callables) {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        try {
//            List<Future> futures = executorService.invokeAll(callables);
//            executorService.shutdown();
//            executorService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS);
//            Map<String, String> result = new HashMap<String, String>();
//            for (Future future : futures) {
//                result.put(response.serviceKey, .toString());
//            }
//            return result;
//        } catch (InterruptedException|ExecutionException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }
    
}
