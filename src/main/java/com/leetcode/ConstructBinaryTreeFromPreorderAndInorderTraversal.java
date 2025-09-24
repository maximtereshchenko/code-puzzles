package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
final class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    TreeNode buildTree(int[] preorder, int[] inorder) {
        var inorderIndices = new HashMap<Integer, Integer>();
        for (var i = 0; i < inorder.length; i++) {
            inorderIndices.put(inorder[i], i);
        }
        return buildTree(new IntIterator(preorder), inorderIndices, 0, inorder.length - 1);
    }

    private TreeNode buildTree(
        Iterator<Integer> preorder,
        Map<Integer, Integer> inorderIndices,
        int left,
        int right
    ) {
        if (left > right) {
            return null;
        }
        var node = new TreeNode();
        node.val = preorder.next();
        var middle = inorderIndices.get(node.val);
        node.left = buildTree(preorder, inorderIndices, left, middle - 1);
        node.right = buildTree(preorder, inorderIndices, middle + 1, right);
        return node;
    }

    private static final class IntIterator implements Iterator<Integer> {

        private final int[] values;
        private int index;

        private IntIterator(int[] values) {
            this.values = values;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < values.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return values[index++];
        }
    }
}
