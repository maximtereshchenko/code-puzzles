package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree
final class MaximumDepthOfBinaryTree {

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
