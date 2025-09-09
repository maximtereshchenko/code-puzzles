package com.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/car-fleet
final class CarFleet {

    int carFleet(int target, int[] positions, int[] speeds) {
        var cars = new int[positions.length][2];
        for (var i = 0; i < positions.length; i++) {
            cars[i][0] = positions[i];
            cars[i][1] = speeds[i];
        }
        Arrays.sort(cars, (a, b) -> -Integer.compare(a[0], b[0]));
        var min = 0.0;
        var fleets = 0;
        for (var car : cars) {
            var time = (double) (target - car[0]) / car[1];
            if (time > min) {
                fleets++;
            }
            min = Math.max(min, time);
        }
        return fleets;
    }
}
