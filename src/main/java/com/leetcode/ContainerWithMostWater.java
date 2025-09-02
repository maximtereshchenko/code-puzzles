package com.leetcode;

//https://leetcode.com/problems/container-with-most-water
final class ContainerWithMostWater {

    int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;
        var max = Integer.MIN_VALUE;
        while (left < right) {
            var leftHeight = height[left];
            var rightHeight = height[right];
            var area = (right - left) * Math.min(leftHeight, rightHeight);
            if (area > max) {
                max = area;
            }
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
