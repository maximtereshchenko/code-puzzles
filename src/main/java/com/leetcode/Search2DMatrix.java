package com.leetcode;

//https://leetcode.com/problems/search-a-2d-matrix
final class Search2DMatrix {

    boolean searchMatrix(int[][] matrix, int target) {
        var row = -1;
        var top = 0;
        var down = matrix.length - 1;
        while (top <= down) {
            var middle = (top + down) / 2;
            var current = matrix[middle][0];
            if (current <= target) {
                top = middle + 1;
                row = Math.max(row, middle);
            }
            if (current > target) {
                down = middle - 1;
            }
        }
        if (row == -1) {
            return false;
        }
        var left = 0;
        var right = matrix[row].length - 1;
        while (left <= right) {
            var middle = (left + right) / 2;
            var current = matrix[row][middle];
            if (current == target) {
                return true;
            }
            if (current < target) {
                left = middle + 1;
            }
            if (current > target) {
                right = middle - 1;
            }
        }
        return false;
    }
}
