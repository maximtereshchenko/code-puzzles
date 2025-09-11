package com.leetcode;

//https://leetcode.com/problems/search-in-rotated-sorted-array
final class SearchInRotatedSortedArray {

    int search(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            var leftValue = numbers[left];
            var rightValue = numbers[right];
            var middleValue = numbers[middle];
            if (middleValue == target) {
                return middle;
            }
            if (leftValue <= middleValue) {
                if (target >= leftValue && target <= middleValue) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target >= middleValue && target <= rightValue) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
