package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

//https://leetcode.com/problems/permutation-in-string
final class PermutationInString {

    private static final int ALLOWED_LETTERS_SIZE = 'z' - 'a' + 1;

    boolean checkInclusion(String source, String target) {
        var sourceLength = source.length();
        if (sourceLength > target.length()) {
            return false;
        }
        return checkInclusion(target, frequencies(source), sourceLength);
    }

    private boolean checkInclusion(
        String target,
        Map<Character, Integer> sourceFrequencies,
        int sourceLength
    ) {
        var windowFrequencies = new HashMap<Character, Integer>();
        var matches = ALLOWED_LETTERS_SIZE - sourceFrequencies.size();
        var left = 0;
        for (int right = 0; right < target.length(); right++) {
            matches = matches(
                sourceFrequencies,
                windowFrequencies,
                target.charAt(right),
                matches,
                x -> x + 1
            );
            if (right - left + 1 == sourceLength + 1) {
                matches = matches(
                    sourceFrequencies,
                    windowFrequencies,
                    target.charAt(left++),
                    matches,
                    x -> x - 1
                );
            }
            if (matches == ALLOWED_LETTERS_SIZE) {
                return true;
            }
        }
        return false;
    }

    private int matches(
        Map<Character, Integer> sourceFrequencies,
        Map<Character, Integer> windowFrequencies,
        char key,
        int matches,
        IntUnaryOperator operator
    ) {
        var updated = operator.applyAsInt(frequency(windowFrequencies, key));
        windowFrequencies.put(key, updated);
        var expected = frequency(sourceFrequencies, key);
        if (updated == expected) {
            return matches + 1;
        }
        if (updated == operator.applyAsInt(expected)) {
            return matches - 1;
        }
        return matches;
    }

    private Map<Character, Integer> frequencies(String string) {
        var frequencies = new HashMap<Character, Integer>();
        for (var i = 0; i < string.length(); i++) {
            char key = string.charAt(i);
            frequencies.put(key, frequency(frequencies, key) + 1);
        }
        return frequencies;
    }

    private int frequency(Map<Character, Integer> frequencies, char key) {
        return frequencies.getOrDefault(key, 0);
    }
}
