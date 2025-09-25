package com.leetcode;

import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array
final class KthLargestElementInArray {

    int findKthLargest(int[] numbers, int k) {
        var priorityQueue = new PriorityQueue<Integer>();
        for (var number : numbers) {
            priorityQueue.add(number);
            if (priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }
        return priorityQueue.remove();
    }
}
