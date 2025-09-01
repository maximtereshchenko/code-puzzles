package com.leetcode;

//https://leetcode.com/problems/product-of-array-except-self
final class ProductOfArrayExceptSelf {

    int[] productExceptSelf(int[] numbers) {
        var result = new int[numbers.length];
        result[0] = 1;
        for (var i = 1; i < numbers.length; i++) {
            result[i] = result[i - 1] * numbers[i - 1];
        }
        var postfix = 1;
        for (var i = numbers.length - 2; i >= 0; i--) {
            postfix *= numbers[i + 1];
            result[i] *= postfix;
        }
        return result;
    }
}
