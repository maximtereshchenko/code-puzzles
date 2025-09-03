package com.leetcode;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters
final class LongestSubstringWithoutRepeatingCharacters {

    int lengthOfLongestSubstring(String string) {
        var longest = 0;
        var characters = new HashMap<Character, Integer>();
        var left = 0;
        for (var right = 0; right < string.length(); right++) {
            var rightCharacter = string.charAt(right);
            if (characters.containsKey(rightCharacter)) {
                left = Math.max(left, characters.get(rightCharacter) + 1);
            }
            characters.put(rightCharacter, right);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
