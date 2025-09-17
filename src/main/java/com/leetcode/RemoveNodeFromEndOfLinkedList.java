package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list
final class RemoveNodeFromEndOfLinkedList {

    ListNode removeNthFromEnd(ListNode head, int offset) {
        var node = head;
        var last = head;
        for (var i = 0; i < offset; i++) {
            last = last.next;
        }
        if (last == null) {
            return node.next;
        }
        while (last.next != null) {
            node = node.next;
            last = last.next;
        }
        node.next = node.next.next;
        return head;
    }
}
