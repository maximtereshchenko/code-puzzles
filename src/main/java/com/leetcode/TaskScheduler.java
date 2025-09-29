package com.leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/task-scheduler
final class TaskScheduler {

    int leastInterval(char[] tasks, int gap) {
        var priorityQueue = new PriorityQueue<Integer>();
        var priorities = new HashMap<Character, Integer>();
        for (var task : tasks) {
            priorityQueue.add(
                priorities.compute(
                    task,
                    (key, current) -> current == null ? 0 : current + gap + 1
                )
            );
        }
        var length = 0;
        for (var turn = 0; !priorityQueue.isEmpty(); length++, turn++) {
            if (priorityQueue.element() <= turn) {
                priorityQueue.remove();
            }
        }
        return length;
    }
}
