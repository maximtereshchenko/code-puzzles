package com.leetcode.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

@JsonDeserialize(using = TreeNode.TreeNodeDeserializer.class)
public final class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof TreeNode treeNode &&
                   val == treeNode.val &&
                   Objects.equals(left, treeNode.left) &&
                   Objects.equals(right, treeNode.right);
    }

    @Override
    public String toString() {
        if (left == null && right == null) {
            return String.valueOf(val);
        }
        return "(%d %s %s)".formatted(val, left, right);
    }

    static final class TreeNodeDeserializer extends StdDeserializer<TreeNode> {

        TreeNodeDeserializer() {
            super(TreeNode.class);
        }

        @Override
        public TreeNode deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
            var values = jsonParser.readValueAs(int[].class);
            if (values.length == 0) {
                return null;
            }
            var root = new TreeNode();
            root.val = values[0];
            var queue = new ArrayDeque<TreeNode>();
            queue.add(root);
            for (var i = 1; i < values.length; i += 2) {
                var node = queue.remove();
                node.left = treeNode(values, i, queue);
                node.right = treeNode(values, i + 1, queue);
            }
            return root;
        }

        private TreeNode treeNode(int[] values, int index, Queue<TreeNode> queue) {
            if (index >= values.length) {
                return null;
            }
            var node = new TreeNode();
            node.val = values[index];
            queue.add(node);
            return node;
        }
    }
}
