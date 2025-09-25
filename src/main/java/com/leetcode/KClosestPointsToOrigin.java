package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin
final class KClosestPointsToOrigin {

    int[][] kClosest(int[][] points, int k) {
        var priorityQueue = new PriorityQueue<>(
            Comparator.comparingDouble(this::distance).reversed()
        );
        for (var point : points) {
            priorityQueue.add(point);
            if (priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }
        return priorityQueue.toArray(int[][]::new);
    }

    private double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}
