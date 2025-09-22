package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/same-tree
final class SameTree {

    boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null || first.val != second.val) {
            return false;
        }
        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }
}
