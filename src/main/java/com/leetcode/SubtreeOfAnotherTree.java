package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/subtree-of-another-tree
final class SubtreeOfAnotherTree {

    boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return equals(root, subRoot) ||
                   (root != null &&
                        (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)));
    }

    private boolean equals(TreeNode first, TreeNode second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        return first.val == second.val &&
                   equals(first.left, second.left) &&
                   equals(first.right, second.right);
    }
}
