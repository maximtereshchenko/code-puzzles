package com.leetcode;

import com.leetcode.common.ListNode;

//https://leetcode.com/problems/add-two-numbers
final class AddTwoNumbers {

    ListNode addTwoNumbers(ListNode firstNode, ListNode secondNode) {
        return addTwoNumbers(0, firstNode, secondNode);
    }

    private ListNode addTwoNumbers(int carryOver, ListNode firstNode, ListNode secondNode) {
        int total = value(firstNode) + value(secondNode) + carryOver;
        int value = total % 10;
        int nextCarryOver = total / 10;
        if (firstNode == null && secondNode == null && value == 0) {
            return null;
        }
        var result = new ListNode();
        result.val = value;
        result.next = addTwoNumbers(nextCarryOver, next(firstNode), next(secondNode));
        return result;
    }

    private int value(ListNode node) {
        if (node == null) {
            return 0;
        }
        return node.val;
    }

    private ListNode next(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.next;
    }
}
