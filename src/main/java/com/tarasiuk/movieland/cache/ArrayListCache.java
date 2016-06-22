package com.tarasiuk.movieland.cache;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static java.util.AbstractMap.*;

@Service
public class ArrayListCache<K, V> implements Cache<K, V> {

    private final List<SimpleEntry<K, V>> cache = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void put(K key, V value) {
        cache.add(new SimpleEntry<>(key, value));
    }

    @Override
    public V get(K key) {
        for (SimpleEntry<K, V> entry : cache) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        Iterator<SimpleEntry<K, V>> iterator = cache.iterator();
        while (iterator.hasNext()) {
            SimpleEntry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                iterator.remove();
            }
        }
    }

    @Override
    public void clear() {
        cache.clear();
    }

    public int size() {
        return cache.size();
    }

    public SimpleEntry<K, V> get (int index) {
        return cache.get(index);
    }

}