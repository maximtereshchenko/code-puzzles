package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/reverse-nodes-in-k-group
final class ReverseNodesInKGroup {

    ListNode reverseKGroup(ListNode head, int length) {
        var current = head;
        ListNode newHead = null;
        ListNode tail = null;
        var currentLength = 0;
        while (current != null && currentLength < length) {
            var node = new ListNode();
            node.val = current.val;
            node.next = newHead;
            newHead = node;
            if (tail == null) {
                tail = node;
            }
            currentLength++;
            current = current.next;
        }
        if (currentLength < length) {
            return head;
        }
        tail.next = reverseKGroup(current, length);
        return newHead;
    }
}
