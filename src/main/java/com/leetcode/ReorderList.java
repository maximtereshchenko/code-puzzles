package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/reorder-list
final class ReorderList {

    void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        reorderList(head, reversed(secondHalf(head, head)));
    }

    private void reorderList(ListNode head, ListNode secondHalf) {
        if (head == null) {
            return;
        }
        var oldNext = head.next;
        head.next = secondHalf;
        if (secondHalf == null) {
            return;
        }
        var oldSecondHalfNext = secondHalf.next;
        secondHalf.next = oldNext;
        reorderList(oldNext, oldSecondHalfNext);
    }

    private ListNode reversed(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var next = head.next;
        var newHead = reversed(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode secondHalf(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return slow;
        }
        var nextSlow = slow.next;
        var nextFast = fast.next.next;
        return secondHalf(nextSlow, nextFast);
    }
}
