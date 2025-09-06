package com.leetcode;

import java.util.ArrayDeque;

//https://leetcode.com/problems/sliding-window-maximum
final class SlidingWindowMaximum {

    int[] maxSlidingWindow(int[] numbers, int windowSize) {
        var deque = new ArrayDeque<Integer>();
        var maximums = new int[numbers.length - windowSize + 1];
        var left = 0;
        for (var right = 0; right < numbers.length; right++) {
            var rightNumber = numbers[right];
            while (!deque.isEmpty() && deque.getLast() < rightNumber) {
                deque.removeLast();
            }
            deque.addLast(rightNumber);
            if (right - left + 1 == windowSize) {
                var first = deque.getFirst();
                maximums[right - windowSize + 1] = first;
                if (numbers[left++] == first) {
                    deque.removeFirst();
                }
            }
        }
        return maximums;
    }
}
