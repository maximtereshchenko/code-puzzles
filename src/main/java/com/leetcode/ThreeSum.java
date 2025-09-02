package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum
final class ThreeSum {

    List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        var result = new ArrayList<List<Integer>>();
        for (var i = 0; i < numbers.length - 2 && numbers[i] <= 0; i++) {
            if (i > 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            twoSum(numbers, i, result);
        }
        return List.copyOf(result);
    }

    private void twoSum(int[] sorted, int start, List<List<Integer>> result) {
        var left = start + 1;
        var right = sorted.length - 1;
        var first = sorted[start];
        var target = -first;
        do {
            var leftValue = sorted[left];
            var rightValue = sorted[right];
            var sum = leftValue + rightValue;
            if (sum == target) {
                result.add(List.of(first, leftValue, rightValue));
            }
            if (sum < target) {
                while (leftValue == sorted[left] && left < right) {
                    left++;
                }
            } else {
                while (rightValue == sorted[right] && left < right) {
                    right--;
                }
            }
        } while (left < right);
    }
}
