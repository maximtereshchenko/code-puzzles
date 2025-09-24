package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum
final class BinaryTreeMaximumPathSum {

    int maxPathSum(TreeNode root) {
        return maximums(root).globalMax();
    }

    private Maximums maximums(TreeNode root) {
        if (root == null) {
            return new Maximums(0, Integer.MIN_VALUE);
        }
        var left = maximums(root.left);
        var right = maximums(root.right);
        var localMax = max(max(left.localMax(), right.localMax()) + root.val, root.val);
        return new Maximums(
            localMax,
            max(
                left.globalMax(),
                right.globalMax(),
                localMax,
                left.localMax() + right.localMax() + root.val
            )
        );
    }

    private int max(int... values) {
        var max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }
        return max;
    }

    private record Maximums(int localMax, int globalMax) {}
}
