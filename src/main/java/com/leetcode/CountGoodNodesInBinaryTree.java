package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree
final class CountGoodNodesInBinaryTree {

    int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        var newMax = Math.max(max, root.val);
        return isGood(root, newMax) +
                   goodNodes(root.left, newMax) +
                   goodNodes(root.right, newMax);
    }

    private int isGood(TreeNode root, int max) {
        if (root.val >= max) {
            return 1;
        }
        return 0;
    }
}
