package com.hotel.aggregator.memcached;

import net.spy.memcached.MemcachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * {@link CacheManager} implementation for Memcached.
 * <p>
 * By default appends prefix {@code memcached:spring-boot}. Custom prefix can be specified
 * in Spring configuration file e.g.
 * <br><br>
 * <code>
 * memcached.cache.prefix=custom-prefix<br>
 * </code>
 */
public class MemcachedCacheManager implements CacheManager {

    private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<>(16);
    final MemcachedClient memcachedClient;

    private String prefix;

    /**
     * Construct a {@link MemcachedCacheManager}
     *
     * @param memcachedClient {@link MemcachedClient}
     */
    public MemcachedCacheManager(MemcachedClient memcachedClient, String prefix) {
        this.memcachedClient = memcachedClient;
        this.prefix = prefix;
    }

    public Cache createCache(String name, int expiration) {
        if (this.cacheMap.containsKey(name)) {
            return getCache(name);
        } else {
            Cache cache = new MemcachedCache(name, memcachedClient, expiration, prefix);
            cacheMap.putIfAbsent(name, cache);
            return cache;
        }
    }
    
    @Override
    public Cache getCache(String name) {
        return this.cacheMap.get(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return Collections.unmodifiableSet(cacheMap.keySet());
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
