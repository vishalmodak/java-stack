package com.hotel.aggregator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.hotel.aggregator.callable.AvailabilityCallable;
import com.hotel.aggregator.callable.DetailsCallable;
import com.hotel.aggregator.callable.RatingsCallable;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.aggregator.clients.HotelRatingClient;

@Service
public class HotelAggregatorService2 {

    private static final int TIMEOUT = 2000;
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Autowired
    private HotelDetailsClient hotelDetailsClient;

    @Autowired
    private HotelRatingClient hotelRatingClient;
    
    @Autowired
    private HotelAvailabilityClient hotelAvailabilityClient;

    public Map<String, String> getHotelData(String hotelId) {
        List<Callable<AsyncResponse>> callables = new ArrayList<>();
        callables.add(new DetailsCallable(hotelDetailsClient, hotelId));
        callables.add(new RatingsCallable(hotelRatingClient, hotelId));
        callables.add(new AvailabilityCallable(hotelAvailabilityClient, hotelId));
//        callables.add(new BackendServiceCallable("pricing", getHotelPricing(hotelId)));
        return doBackendAsyncServiceCall(callables);
    }
    
    private static Map<String, String> doBackendAsyncServiceCall(List<Callable<AsyncResponse>> callables) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            List<Future<AsyncResponse>> futures = executorService.invokeAll(callables);
            executorService.shutdown();
            executorService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS);
            Map<String, String> result = new HashMap<String, String>();
            for (Future<AsyncResponse> future : futures) {
                AsyncResponse response = future.get();
                result.put(response.serviceKey, response.response);
            }
            return result;
        } catch (InterruptedException|ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    
}
