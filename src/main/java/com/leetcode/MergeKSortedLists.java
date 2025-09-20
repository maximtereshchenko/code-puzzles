package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/merge-k-sorted-lists
final class MergeKSortedLists {

    ListNode mergeKLists(ListNode[] lists) {
        return listNode(lists, 0, lists.length - 1);
    }

    private ListNode listNode(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        var middle = (left + right) / 2;
        return merged(listNode(lists, left, middle), listNode(lists, middle + 1, right));
    }

    private ListNode merged(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        var node = new ListNode();
        if (left.val < right.val) {
            node.val = left.val;
            node.next = merged(left.next, right);
        } else {
            node.val = right.val;
            node.next = merged(left, right.next);
        }
        return node;
    }
}
