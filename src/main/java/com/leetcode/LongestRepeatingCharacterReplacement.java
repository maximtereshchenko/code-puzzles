package com.leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/longest-repeating-character-replacement
final class LongestRepeatingCharacterReplacement {

    int characterReplacement(String string, int maxReplacements) {
        var frequencies = new HashMap<Character, Integer>();
        var left = 0;
        var longest = 0;
        var maxFrequency = 0;
        for (var right = 0; right < string.length(); right++) {
            var current = string.charAt(right);
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
            //The 'maxFrequency' does not need to be decremented.
            //The 'longest' will only be updated when the window length has a higher value.
            //The window length depends on the constant 'maxReplacements' and 'maxFrequency'
            maxFrequency = Math.max(maxFrequency, frequencies.get(current));
            while (right - left + 1 - maxFrequency > maxReplacements) {
                var leftValue = string.charAt(left);
                frequencies.put(leftValue, frequencies.get(leftValue) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
