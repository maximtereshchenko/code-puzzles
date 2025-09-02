package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://leetcode.com/problems/longest-consecutive-sequence
final class LongestConsecutiveSequence {

    int longestConsecutive(int[] numbers) {
        var set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
        var longest = 0;
        for (var current : set) {
            if (!set.contains(current - 1)) {
                var length = 1;
                for (var i = current; set.contains(i + 1); i++) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
