package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree
final class BalancedBinaryTree {

    boolean isBalanced(TreeNode root) {
        return balance(root) instanceof Balanced;
    }

    private Balance balance(TreeNode root) {
        if (root == null) {
            return new Balanced(0);
        }
        return switch (balance(root.left)) {
            case Balanced(var left) -> switch (balance(root.right)) {
                case Balanced(var right) -> {
                    if (Math.abs(left - right) <= 1) {
                        yield new Balanced(1 + Math.max(left, right));
                    }
                    yield new Unbalanced();
                }
                case Unbalanced unbalanced -> unbalanced;
            };
            case Unbalanced unbalanced -> unbalanced;
        };
    }

    private sealed interface Balance {}

    private record Balanced(int height) implements Balance {}

    private record Unbalanced() implements Balance {}
}
