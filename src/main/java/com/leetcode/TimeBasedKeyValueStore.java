package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/time-based-key-value-store
final class TimeBasedKeyValueStore {

    private final Map<String, List<TimeBasedValue>> map = new HashMap<>();

    void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, ignored -> new ArrayList<>())
            .add(new TimeBasedValue(value, timestamp));
    }

    String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        var values = map.get(key);
        var value = "";
        var left = 0;
        var right = values.size() - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            var timeBasedValue = values.get(middle);
            if (timeBasedValue.timestamp() <= timestamp) {
                left = middle + 1;
                value = timeBasedValue.value();
            } else {
                right = middle - 1;
            }
        }
        return value;
    }

    private record TimeBasedValue(String value, int timestamp) {}
}
