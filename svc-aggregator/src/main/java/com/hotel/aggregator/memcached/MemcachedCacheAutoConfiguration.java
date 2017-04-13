package com.hotel.aggregator.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collections;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.spy.memcached.DefaultConnectionFactory;
import net.spy.memcached.MemcachedClient;

@Configuration
public class MemcachedCacheAutoConfiguration {

    @Value("${memcached.cache.host:localhost}")
    private String host;
    @Value("${memcached.cache.port:11211}")
    private Integer port;
    @Value("${memcached.cache.expiration:3600}")
    private Integer expiration;
    @Value("${memcached.cache.prefix}")
    private String prefix;


    private MemcachedClient memcachedClient() throws IOException {

        return new MemcachedClient(new DefaultConnectionFactory(),
                Collections.singletonList(new InetSocketAddress(host, port)));
    }

    @Bean
    public MemcachedCacheManager cacheManager() throws IOException {
        return new DisposableMemcachedCacheManager(memcachedClient());
    }

    protected class DisposableMemcachedCacheManager extends MemcachedCacheManager implements DisposableBean {

        public DisposableMemcachedCacheManager(MemcachedClient memcachedClient) {
            super(memcachedClient, prefix);
        }

        @Override
        public void destroy() throws Exception {
            this.memcachedClient.shutdown();
        }
    }
}
