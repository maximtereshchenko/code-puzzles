package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight
final class LastStoneWeight {

    int lastStoneWeight(int[] stones) {
        var priorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (var stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() >= 2) {
            var remaining = priorityQueue.remove() - priorityQueue.remove();
            if (remaining > 0) {
                priorityQueue.add(remaining);
            }
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        }
        return priorityQueue.remove();
    }
}
