package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree
final class SerializeAndDeserializeBinaryTree {

    private static final char SEPARATOR = ',';

    String serialize(TreeNode root) {
        var builder = new StringBuilder();
        serialize(root, builder);
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    TreeNode deserialize(String data) {
        return node(new IntegerIterator(data));
    }

    private TreeNode node(Iterator<Integer> iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        var value = iterator.next();
        if (value == null) {
            return null;
        }
        var node = new TreeNode();
        node.val = value;
        node.left = node(iterator);
        node.right = node(iterator);
        return node;
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root != null) {
            builder.append(root.val);
        }
        builder.append(SEPARATOR);
        if (root != null) {
            serialize(root.left, builder);
            serialize(root.right, builder);
        }
    }

    private static final class IntegerIterator implements Iterator<Integer> {

        private final String string;
        private int index;

        IntegerIterator(String string) {
            this.string = string;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < string.length();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var end = end();
            var next = next(end);
            index = end + 1;
            return next;
        }

        private int end() {
            var end = string.indexOf(SEPARATOR, index);
            if (end == -1) {
                return string.length();
            }
            return end;
        }

        private Integer next(int end) {
            if (end == index) {
                return null;
            }
            return Integer.valueOf(string.substring(index, end));
        }
    }
}
