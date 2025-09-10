package com.leetcode;

//https://leetcode.com/problems/binary-search
final class BinarySearch {

    int search(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            var current = numbers[middle];
            if (current == target) {
                return middle;
            }
            if (current < target) {
                left = middle + 1;
            }
            if (current > target) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
