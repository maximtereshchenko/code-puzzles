package com.leetcode;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
final class FindMinimumInRotatedSortedArray {

    int findMin(int[] numbers) {
        var left = 0;
        var right = numbers.length - 1;
        while (left < right) {
            var leftValue = numbers[left];
            var rightValue = numbers[right];
            if (leftValue < rightValue) {
                return leftValue;
            }
            var middle = (left + right) / 2;
            if (numbers[middle] < rightValue) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return numbers[left];
    }
}
