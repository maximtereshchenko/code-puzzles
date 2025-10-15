package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream
final class FindMedianFromDataStream {

    private final PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> right = new PriorityQueue<>();

    void addNum(int num) {
        left.add(num);
        if (left.size() - right.size() > 1 ||
                (!right.isEmpty() && left.element() > right.element())) {
            right.add(left.remove());
        }
        if (left.size() < right.size()) {
            left.add(right.remove());
        }
    }

    double findMedian() {
        if (left.size() == right.size()) {
            return (left.element() + right.element()) / 2.0;
        }
        return left.element();
    }
}
