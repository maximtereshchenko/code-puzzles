package com.leetcode;

final class TrappingRainWater {

    int trap(int[] height) {
        var left = 0;
        var right = height.length - 1;
        var leftMaximum = height[left];
        var rightMaximum = height[right];
        var trapped = 0;
        while (left < right) {
            if (leftMaximum < rightMaximum) {
                left++;
                var current = height[left];
                trapped += Math.max(0, leftMaximum - current);
                leftMaximum = Math.max(leftMaximum, current);
            } else {
                right--;
                var current = height[right];
                trapped += Math.max(0, rightMaximum - current);
                rightMaximum = Math.max(rightMaximum, current);
            }
        }
        return trapped;
    }
}
