package com.leetcode;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
final class TwoSumInputArrayIsSorted {

    int[] twoSum(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;
        do {
            var sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        } while (right < numbers.length);
        throw new IllegalStateException();
    }
}
