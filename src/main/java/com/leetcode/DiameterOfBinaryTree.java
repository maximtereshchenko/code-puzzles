package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree
final class DiameterOfBinaryTree {

    int diameterOfBinaryTree(TreeNode root) {
        return heightDiameter(root).diameter();
    }

    private HeightDiameter heightDiameter(TreeNode root) {
        if (root == null) {
            return new HeightDiameter(0, 0);
        }
        var left = heightDiameter(root.left);
        var right = heightDiameter(root.right);
        return new HeightDiameter(
            1 + Math.max(left.height(), right.height()),
            Math.max(
                Math.max(left.diameter(), right.diameter()),
                left.height() + right.height()
            )
        );
    }

    private record HeightDiameter(int height, int diameter) {}
}
