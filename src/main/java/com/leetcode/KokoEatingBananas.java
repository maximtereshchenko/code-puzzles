package com.leetcode;

//https://leetcode.com/problems/koko-eating-bananas
final class KokoEatingBananas {

    int minEatingSpeed(int[] piles, int hours) {
        var right = 0;
        for (var pile : piles) {
            right = Math.max(right, pile);
        }
        var minSpeed = Integer.MAX_VALUE;
        var left = 1;
        while (left <= right) {
            var speed = (left + right) / 2;
            var currentHours = 0L;
            for (var pile : piles) {
                currentHours += Math.ceilDiv(pile, speed);
            }
            if (currentHours > hours) {
                left = speed + 1;
            }
            if (currentHours <= hours) {
                right = speed - 1;
                minSpeed = Math.min(minSpeed, speed);
            }
        }
        return minSpeed;
    }
}
