package com.leetcode;

import java.util.ArrayDeque;

//https://leetcode.com/problems/sliding-window-maximum
final class SlidingWindowMaximum {

    int[] maxSlidingWindow(int[] numbers, int windowSize) {
        var monotonicallyDecreasingQueue = new ArrayDeque<Integer>();
        var maximums = new int[numbers.length - windowSize + 1];
        var left = 0;
        for (var right = 0; right < numbers.length; right++) {
            var rightNumber = numbers[right];
            while (!monotonicallyDecreasingQueue.isEmpty() &&
                       monotonicallyDecreasingQueue.getLast() < rightNumber) {
                monotonicallyDecreasingQueue.removeLast();
            }
            monotonicallyDecreasingQueue.addLast(rightNumber);
            if (right - left + 1 == windowSize) {
                var first = monotonicallyDecreasingQueue.getFirst();
                maximums[right - windowSize + 1] = first;
                if (numbers[left++] == first) {
                    monotonicallyDecreasingQueue.removeFirst();
                }
            }
        }
        return maximums;
    }
}
