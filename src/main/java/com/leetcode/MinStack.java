package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/min-stack
final class MinStack {

    private final Deque<Long> differences = new ArrayDeque<>();
    private long minimum;

    void push(int value) {
        if (differences.isEmpty()) {
            minimum = value;
            differences.addLast(0L);
        } else {
            differences.addLast(value - minimum);
            minimum = Math.min(minimum, value);
        }
    }

    void pop() {
        if (differences.isEmpty()) {
            throw new IllegalStateException();
        }
        minimum = minimum - Math.min(differences.removeLast(), 0);
    }

    int top() {
        if (differences.isEmpty()) {
            throw new IllegalStateException();
        }
        return Math.toIntExact(minimum + Math.max(differences.getLast(), 0));
    }

    int getMin() {
        if (differences.isEmpty()) {
            throw new IllegalStateException();
        }
        return Math.toIntExact(minimum);
    }
}
