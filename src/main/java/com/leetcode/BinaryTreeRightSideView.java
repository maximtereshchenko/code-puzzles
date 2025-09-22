package com.leetcode;

import com.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view
final class BinaryTreeRightSideView {

    List<Integer> rightSideView(TreeNode root) {
        var view = new ArrayList<Integer>();
        var nodes = new ArrayDeque<TreeNode>();
        add(root, nodes);
        rightSideView(view, nodes);
        return view;
    }

    private void rightSideView(List<Integer> view, Queue<TreeNode> nodes) {
        if (nodes.isEmpty()) {
            return;
        }
        var size = nodes.size();
        for (var i = 0; i < size; i++) {
            var node = nodes.remove();
            if (i == size - 1) {
                view.add(node.val);
            }
            add(node.left, nodes);
            add(node.right, nodes);
        }
        rightSideView(view, nodes);
    }

    private void add(TreeNode node, Queue<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(node);
    }
}
