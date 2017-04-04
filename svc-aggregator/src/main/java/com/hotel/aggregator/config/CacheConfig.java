package com.hotel.aggregator.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CacheConfig {

   public final static String CACHE_DETAILS = "details";
   public final static String CACHE_RATINGS = "ratings";
   public final static String CACHE_AVAILABILITY = "availability";

   @Bean
   public Cache cacheDetails() {
      return new CaffeineCache(CACHE_DETAILS, Caffeine.newBuilder()
            .expireAfterWrite(60, TimeUnit.SECONDS)
            .recordStats()
            .build());
   }

   @Bean
   public Cache cacheRatings() {
      return new CaffeineCache(CACHE_RATINGS, Caffeine.newBuilder()
            .expireAfterWrite(30, TimeUnit.SECONDS)
            .recordStats()
            .build());
   }
   
   @Bean
   public Cache cacheAvailability() {
      return new CaffeineCache(CACHE_AVAILABILITY, Caffeine.newBuilder()
            .expireAfterWrite(15, TimeUnit.SECONDS)
            .recordStats()
            .build());
   }
   
   @Bean
   public Cache cacheAggregate() {
      return new CaffeineCache("aggregate", Caffeine.newBuilder()
            .expireAfterWrite(15, TimeUnit.SECONDS)
            .recordStats()
            .build());
   }
}
