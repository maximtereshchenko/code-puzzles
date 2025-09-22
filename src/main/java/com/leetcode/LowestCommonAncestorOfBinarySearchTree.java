package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
final class LowestCommonAncestorOfBinarySearchTree {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode first, TreeNode second) {
        return lowestCommonAncestor(root, first.val, second.val);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int lower, int upper) {
        if (lower > upper) {
            return lowestCommonAncestor(root, upper, lower);
        }
        if (root == null) {
            return null;
        }
        if (root.val > upper) {
            return lowestCommonAncestor(root.left, lower, upper);
        }
        if (root.val < lower) {
            return lowestCommonAncestor(root.right, lower, upper);
        }
        return root;
    }
}
