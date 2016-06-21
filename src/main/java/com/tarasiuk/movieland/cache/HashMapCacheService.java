package com.tarasiuk.movieland.cache;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

@Service
public class HashMapCacheService<K, V> implements CacheService<K, V> {

    private final Map<K, V> cacheGenre = Collections.synchronizedMap(new WeakHashMap<>());

    @Override
    public void put(K key, V value) {
        cacheGenre.put(key, value);
    }

    @Override
    public V get(K key) {
        return cacheGenre.get(key);
    }

    @Override
    public void clear() {
        cacheGenre.clear();
    }
}
