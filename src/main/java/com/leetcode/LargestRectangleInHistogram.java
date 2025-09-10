package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/largest-rectangle-in-histogram
final class LargestRectangleInHistogram {

    int largestRectangleArea(int[] heights) {
        var stack = new ArrayDeque<int[]>();
        stack.addLast(new int[]{-1, 0});
        var largestRectangleArea = 0;
        for (var i = 0; i < heights.length; i++) {
            largestRectangleArea = Math.max(
                largestRectangleArea,
                largestRectangleArea(stack, i, heights[i])
            );
        }
        largestRectangleArea = Math.max(
            largestRectangleArea,
            largestRectangleArea(stack, heights.length, 0)
        );
        return largestRectangleArea;
    }

    private int largestRectangleArea(Deque<int[]> stack, int index, int height) {
        var last = stack.getLast();
        var largestRectangleArea = 0;
        while (last[1] > height) {
            stack.removeLast();
            largestRectangleArea = Math.max(
                largestRectangleArea,
                (index - stack.getLast()[0] - 1) * last[1]
            );
            last = stack.getLast();
        }
        stack.addLast(new int[]{index, height});
        return largestRectangleArea;
    }
}
