package com.leetcode;

//https://leetcode.com/problems/find-the-duplicate-number
final class FindTheDuplicateNumber {

    int findDuplicate(int[] numbers) {
        var slow = 0;
        var fast = slow;
        do {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
        } while (slow != fast);
        var secondSlow = 0;
        while (slow != secondSlow) {
            slow = numbers[slow];
            secondSlow = numbers[secondSlow];
        }
        return slow;
    }
}
