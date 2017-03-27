package com.hotel.aggregator;

public class AsyncResponse {
    public final String serviceKey;
    public final String response;
    
    public AsyncResponse(String serviceKey, String response) {
        this.serviceKey = serviceKey;
        this.response = response;
    }
}