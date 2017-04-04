package com.hotel.aggregator;

import java.lang.reflect.Type;
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
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hotel.aggregator.clients.HotelAvailabilityClient;
import com.hotel.aggregator.clients.HotelDetailsClient;
import com.hotel.aggregator.clients.HotelRatingClient;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

@Service
public class HotelAggregatorService {
    private static final String DETAILS_GROUP = "details";
    private static final String RATING_GROUP = "rating";
    private static final String AVAIL_GROUP = "avail";
    
    @Autowired
    private HotelDetailsClient hotelDetailsClient;

    @Autowired
    private HotelRatingClient hotelRatingClient;
    
    @Autowired
    private HotelAvailabilityClient hotelAvailabilityClient;
    

    public Map<String, String> getHotelSummary(String hotelId) {
        List<Callable<AsyncResponse>> callables = new ArrayList<>();
        callables.add(new BackendServiceCallable("details", getHotelDetails(hotelId)));
        return doBackendAsyncServiceCall(callables);
    }

    
    public Map<String, String> getHotelInfo(String hotelId) {
        List<Callable<AsyncResponse>> callables = new ArrayList<>();
        callables.add(new BackendServiceCallable("details", getHotelDetails(hotelId)));
        callables.add(new BackendServiceCallable("avail", getHotelAvailability(hotelId)));
        callables.add(new BackendServiceCallable("ratings", getHotelRatings(hotelId)));
        return doBackendAsyncServiceCall(callables);
    }
    
    private static Map<String, String> doBackendAsyncServiceCall(List<Callable<AsyncResponse>> callables) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            List<Future<AsyncResponse>> futures = executorService.invokeAll(callables);
            executorService.shutdown();
            executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);
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
    
//    @Cacheable
    private HystrixCommand<String> getHotelDetails(final String hotelId) {
        return new HystrixCommand<String>(
                HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(DETAILS_GROUP))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("getHotelDetails"))
                        .andThreadPoolPropertiesDefaults(
                                HystrixThreadPoolProperties.Setter().withCoreSize(5).withMaxQueueSize(2)
                        )
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerErrorThresholdPercentage(20)
                        )
        ) {
            @Override
            protected String run() throws Exception {
                return hotelDetailsClient.getHotelDetails(hotelId);
            }
            @Override
            protected String getFallback() {
                return "DEFAULT";
            }
        };
    }
    
    private HystrixCommand<String> getHotelAvailability(final String hotelId) {
        return new HystrixCommand<String>(
                HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(AVAIL_GROUP))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("getAvailability"))
                        .andThreadPoolPropertiesDefaults(
                                HystrixThreadPoolProperties.Setter().withCoreSize(5).withMaxQueueSize(2)
                        )
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerErrorThresholdPercentage(10)
                        )
        ) {
            @Override
            protected String run() throws Exception {
                Type type = new TypeToken<HashMap<String, String>>(){}.getType();
                Map<String, String> map = new Gson().fromJson(hotelAvailabilityClient.getHotelAvailability(hotelId), type);
                return map.get("price") + ", " + map.get("availability");
            }
            @Override
            protected String getFallback() {
                return "UNKNOWN";
            }
        };
    }
    
    private HystrixCommand<String> getHotelRatings(final String hotelId) {
        return new HystrixCommand<String>(
                HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(RATING_GROUP))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("getHotelRating"))
                        .andThreadPoolPropertiesDefaults(
                                HystrixThreadPoolProperties.Setter().withCoreSize(5).withMaxQueueSize(2)
                        )
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerErrorThresholdPercentage(5)
                        )
        ) {
            @Override
            protected String run() throws Exception {
                return hotelRatingClient.getHotelRating(hotelId);
            }
            @Override
            protected String getFallback() {
                return "0";
            }
        };
    }
    
    private static class AsyncResponse {
        private final String serviceKey;
        private final String response;
        AsyncResponse(String serviceKey, String response) {
            this.serviceKey = serviceKey;
            this.response = response;
        }
    }
    private static class BackendServiceCallable implements Callable<AsyncResponse> {
        private final String serviceKey;
        private final HystrixCommand<String> hystrixCommand;
        public BackendServiceCallable(String serviceKey, HystrixCommand<String> hystrixCommand) {
            this.serviceKey = serviceKey;
            this.hystrixCommand = hystrixCommand;
        }
        @Override
        public AsyncResponse call() throws Exception {
            return new AsyncResponse(serviceKey, hystrixCommand.execute());
        }
    }
}
