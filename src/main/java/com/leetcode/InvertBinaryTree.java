package com.leetcode;

import com.leetcode.common.TreeNode;

final class InvertBinaryTree {

    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        var oldLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(oldLeft);
        return root;
    }
}
