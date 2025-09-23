package com.leetcode;

import com.leetcode.common.TreeNode;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst
final class KthSmallestElementInBST {

    int kthSmallest(TreeNode root, int index) {
        if (!(search(root, index) instanceof Found(var value))) {
            throw new IllegalStateException();
        }
        return value;
    }

    Search search(TreeNode root, int remaining) {
        if (root == null) {
            return new NotFound(remaining);
        }
        return switch (search(root.left, remaining)) {
            case Found found -> found;
            case NotFound(var remainingAfterLeft) -> {
                var remainingAfterThis = remainingAfterLeft - 1;
                if (remainingAfterThis == 0) {
                    yield new Found(root.val);
                }
                yield search(root.right, remainingAfterThis);
            }
        };
    }

    private sealed interface Search {}

    private record Found(int value) implements Search {}

    private record NotFound(int nodes) implements Search {}
}
