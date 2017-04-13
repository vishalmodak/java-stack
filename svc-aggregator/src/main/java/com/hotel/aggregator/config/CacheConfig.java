package com.hotel.aggregator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.aggregator.memcached.MemcachedCacheManager;

@Configuration
public class CacheConfig {

   public final static String CACHE_DETAILS = "details";
   public final static String CACHE_RATINGS = "ratings";
   public final static String CACHE_AVAILABILITY = "availability";
   
   @Autowired
   MemcachedCacheManager cacheManager;
   
   @Bean
   public Cache cacheDetails() {
      return cacheManager.createCache(CACHE_DETAILS, 60);
   }

   @Bean
   public Cache cacheRatings() {
       return cacheManager.createCache(CACHE_RATINGS, 60);
   }
   
   @Bean
   public Cache cacheAvailability() {
       return cacheManager.createCache(CACHE_AVAILABILITY, 15);
   }

//   @Bean
//   public Cache cacheDetails() {
//      return new CaffeineCache(CACHE_DETAILS, Caffeine.newBuilder()
//            .expireAfterWrite(60, TimeUnit.SECONDS)
//            .recordStats()
//            .build());
//   }
//
//   @Bean
//   public Cache cacheRatings() {
//      return new CaffeineCache(CACHE_RATINGS, Caffeine.newBuilder()
//            .expireAfterWrite(30, TimeUnit.SECONDS)
//            .recordStats()
//            .build());
//   }
//   
//   @Bean
//   public Cache cacheAvailability() {
//      return new CaffeineCache(CACHE_AVAILABILITY, Caffeine.newBuilder()
//            .expireAfterWrite(15, TimeUnit.SECONDS)
//            .recordStats()
//            .build());
//   }
//   
//   @Bean
//   public Cache cacheAggregate() {
//      return new CaffeineCache("aggregate", Caffeine.newBuilder()
//            .expireAfterWrite(15, TimeUnit.SECONDS)
//            .recordStats()
//            .build());
//   }
}
