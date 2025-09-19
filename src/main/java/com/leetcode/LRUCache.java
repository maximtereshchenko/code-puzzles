package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache
final class LRUCache {

    private final Map<Integer, Integer> cache;

    LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity + 1, 0.1f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        cache.put(key, value);
    }
}
