package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/reverse-linked-list
final class ReverseLinkedList {

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var next = head.next;
        var newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
