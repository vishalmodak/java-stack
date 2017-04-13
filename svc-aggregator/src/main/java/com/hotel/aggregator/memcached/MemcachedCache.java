package com.hotel.aggregator.memcached;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.cache.support.AbstractValueAdaptingCache;

import net.spy.memcached.MemcachedClient;

/**
 * Cache implementation on top of Memcached.
 */
public class MemcachedCache extends AbstractValueAdaptingCache {

    private static final String KEY_DELIMITER = ":";

    private final MemcachedClient memcachedClient;
    private final MemcacheCacheMetadata memcacheCacheMetadata;

    private final Lock lock = new ReentrantLock();

    /**
     * Create an {@code MemcachedCache} with the given settings.
     *
     * @param name            Cache name
     * @param memcachedClient {@link MemcachedClient}
     * @param expiration      Cache expiration in seconds
     * @param prefix          Cache key prefix
     */
    public MemcachedCache(String name, MemcachedClient memcachedClient, int expiration, String prefix) {
        super(true);
        this.memcachedClient = memcachedClient;
        this.memcacheCacheMetadata = new MemcacheCacheMetadata(name, expiration, prefix);
    }

    @Override
    protected Object lookup(Object key) {
        return memcachedClient.get(new MemcachedKey(key).value());
    }

    @Override
    public String getName() {
        return this.memcacheCacheMetadata.name();
    }

    @Override
    public Object getNativeCache() {
        return this.memcachedClient;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        Object value = lookup(key);
        if (value != null) {
            return (T) fromStoreValue(value);
        }

        lock.lock();
        try {
            value = lookup(key);
            if (value != null) {
                return (T) fromStoreValue(value);
            } else {
                return loadValue(key, valueLoader);
            }
        } finally {
            lock.unlock();
        }
    }

    private <T> T loadValue(Object key, Callable<T> valueLoader) {
        T value;
        try {
            value = valueLoader.call();
        } catch (Exception e) {
            throw new ValueRetrievalException(key, valueLoader, e);
        }
        put(key, value);
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        this.memcachedClient.set(new MemcachedKey(key).value(), this.memcacheCacheMetadata.expiration(), value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Object existingValue = lookup(key);
        if (existingValue == null) {
            put(key, value);
            return toValueWrapper(value);
        }

        return toValueWrapper(existingValue);
    }

    @Override
    public void evict(Object key) {
        this.memcachedClient.delete(new MemcachedKey(key).value());
    }

    @Override
    public void clear() {
        //NO OP
    }

    /**
     * Wrapper class for the Memcached key value.
     *
     * All whitespace characters will be stripped from the key value, for Memcached
     * key to be valid.
     */
    class MemcachedKey {
        private final StringBuilder value;

        public MemcachedKey(Object key) {
            this.value = new StringBuilder(memcacheCacheMetadata.cachePrefix())
                    .append(KEY_DELIMITER)
                    .append(String.valueOf(key).replaceAll("\\s", ""));
        }

        String value() {
            return this.value.toString();
        }

    }

    class MemcacheCacheMetadata {
        private final String name;
        private final int expiration;
        private final String cachePrefix;

        public MemcacheCacheMetadata(String name, int expiration, String cachePrefix) {
            this.name = name;
            this.expiration = expiration;

            StringBuilder sb = new StringBuilder(cachePrefix)
                    .append(KEY_DELIMITER)
                    .append(name);

            this.cachePrefix = sb.toString();
        }

        public String name() {
            return name;
        }

        public int expiration() {
            return expiration;
        }

        public String cachePrefix() {
            return cachePrefix;
        }
    }

}
