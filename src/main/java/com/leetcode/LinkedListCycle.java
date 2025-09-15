package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/linked-list-cycle
final class LinkedListCycle {

    boolean hasCycle(ListNode head) {
        return hasCycle(head, head);
    }

    private boolean hasCycle(ListNode slow, ListNode fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        var nextSlow = slow.next;
        var nextFast = fast.next.next;
        if (nextSlow == nextFast) {
            return true;
        }
        return hasCycle(nextSlow, nextFast);
    }
}
