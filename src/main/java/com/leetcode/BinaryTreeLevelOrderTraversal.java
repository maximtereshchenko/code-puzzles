package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal
final class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        var levels = new ArrayList<List<Integer>>();
        var nodes = new ArrayDeque<TreeNode>();
        nodes.add(root);
        levelOrder(levels, nodes);
        return levels;
    }

    private void levelOrder(List<List<Integer>> levels, Queue<TreeNode> nodes) {
        var size = nodes.size();
        var current = new ArrayList<Integer>(size);
        for (var i = 0; i < size; i++) {
            var node = nodes.remove();
            current.add(node.val);
            add(node.left, nodes);
            add(node.right, nodes);
        }
        levels.add(current);
        if (!nodes.isEmpty()) {
            levelOrder(levels, nodes);
        }
    }

    private void add(TreeNode node, Queue<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node);
    }
}
