package com.tarasiuk.movieland.cache;

public interface CacheService<K, V> {

    void put(K key, V value);

    V get(K key);

    void clear();

}
