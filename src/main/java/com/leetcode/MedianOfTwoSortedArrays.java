package com.leetcode;

//https://leetcode.com/problems/median-of-two-sorted-arrays
final class MedianOfTwoSortedArrays {

    double findMedianSortedArrays(int[] numbers1, int[] numbers2) {
        if (numbers1.length > numbers2.length) {
            return findMedianSortedArrays(numbers2, numbers1);
        }
        var totalLength = numbers1.length + numbers2.length;
        var totalLeftSize = (totalLength) / 2;
        var leftSizeInFirst = leftSizeInFirst(numbers1, numbers2, totalLeftSize);
        var leftSizeInSecond = totalLeftSize - leftSizeInFirst;
        var rightMin = Math.min(
            value(numbers1, leftSizeInFirst, Integer.MAX_VALUE),
            value(numbers2, leftSizeInSecond, Integer.MAX_VALUE)
        );
        return (
            leftMax(
                numbers1,
                numbers2,
                totalLength,
                leftSizeInFirst,
                leftSizeInSecond,
                rightMin
            ) + rightMin
        ) / 2.0;
    }

    private int leftMax(
        int[] numbers1,
        int[] numbers2,
        int totalLength,
        int leftSizeInFirst,
        int leftSizeInSecond,
        int rightMin
    ) {
        if (totalLength % 2 == 0) {
            return Math.max(
                value(numbers1, leftSizeInFirst - 1, Integer.MIN_VALUE),
                value(numbers2, leftSizeInSecond - 1, Integer.MIN_VALUE)
            );
        }
        return rightMin;
    }

    private int value(int[] numbers, int index, int defaultValue) {
        if (index < 0 || index >= numbers.length) {
            return defaultValue;
        }
        return numbers[index];
    }

    private int leftSizeInFirst(int[] numbers1, int[] numbers2, int totalLeftSize) {
        var left = 0;
        var right = numbers1.length - 1;
        var leftSize = 0;
        while (left <= right) {
            var middle = (left + right) / 2;
            var middleValue = numbers1[middle];
            if (middleValue <= numbers2[totalLeftSize - middle - 1]) {
                left = middle + 1;
                leftSize = Math.max(leftSize, middle + 1);
            } else {
                right = middle - 1;
            }
        }
        return leftSize;
    }
}
