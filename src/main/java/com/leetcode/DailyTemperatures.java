package com.leetcode;

import java.util.ArrayDeque;

//https://leetcode.com/problems/daily-temperatures
final class DailyTemperatures {

    int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        var monotonicallyDecreasingQueue = new ArrayDeque<Integer>();
        for (var i = 0; i < temperatures.length; i++) {
            while (
                !monotonicallyDecreasingQueue.isEmpty() &&
                    temperatures[monotonicallyDecreasingQueue.getLast()] < temperatures[i]
            ) {
                var resultIndex = monotonicallyDecreasingQueue.removeLast();
                result[resultIndex] = i - resultIndex;
            }
            monotonicallyDecreasingQueue.addLast(i);
        }
        return result;
    }
}
