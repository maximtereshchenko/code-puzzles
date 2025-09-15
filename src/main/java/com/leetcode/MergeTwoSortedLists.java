package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists
final class MergeTwoSortedLists {

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        var head = new ListNode();
        if (list2 == null || list1.val <= list2.val) {
            head.val = list1.val;
            head.next = mergeTwoLists(list1.next, list2);
        } else {
            head.val = list2.val;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }
}
