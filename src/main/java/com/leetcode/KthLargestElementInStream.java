package com.leetcode;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream
final class KthLargestElementInStream {

    private final PriorityQueue<Integer> priorityQueue;
    private final int size;

    KthLargestElementInStream(int offset, int[] numbers) {
        this.priorityQueue = new PriorityQueue<>();
        this.size = offset;
        for (var number : numbers) {
            add(number);
        }
    }

    int add(int value) {
        priorityQueue.add(value);
        if (priorityQueue.size() > size) {
            priorityQueue.remove();
        }
        return priorityQueue.element();
    }
}
