package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring
final class MinimumWindowSubstring {

    String minWindow(String string, String pattern) {
        if (string.length() < pattern.length()) {
            return "";
        }
        Range min = new EmptyRange();
        var window = new Window(string, Frequencies.from(pattern));
        while (window.canExtend()) {
            window.extend();
            while (window.canShrink()) {
                var range = window.range();
                if (range.length() < min.length()) {
                    min = range;
                }
                window.shrink();
            }
        }
        return min.substring(string);
    }

    private interface Range {

        int length();

        String substring(String string);
    }

    private static final class Window {

        private final String string;
        private final Frequencies patternFrequencies;
        private final Frequencies windowFrequencies;
        private int matched;
        private int left;
        private int right;

        Window(String string, Frequencies patternFrequencies) {
            this.string = string;
            this.patternFrequencies = patternFrequencies;
            this.windowFrequencies = new Frequencies();
            this.matched = 0;
            this.left = 0;
            this.right = 0;
        }

        boolean canExtend() {
            return right < string.length();
        }

        void extend() {
            var rightChar = string.charAt(right++);
            if (!patternFrequencies.has(rightChar)) {
                return;
            }
            windowFrequencies.increment(rightChar);
            if (windowFrequencies.frequency(rightChar) == patternFrequencies.frequency(rightChar)) {
                matched++;
            }
        }

        boolean canShrink() {
            return matched == patternFrequencies.size();
        }

        BoundedRange range() {
            return new BoundedRange(left, right);
        }

        void shrink() {
            var leftChar = string.charAt(left++);
            if (!windowFrequencies.has(leftChar)) {
                return;
            }
            var leftCharFrequency = windowFrequencies.frequency(leftChar);
            windowFrequencies.decrement(leftChar);
            if (leftCharFrequency == patternFrequencies.frequency(leftChar)) {
                matched--;
            }
        }
    }

    private record EmptyRange() implements Range {

        @Override
        public int length() {
            return Integer.MAX_VALUE;
        }

        @Override
        public String substring(String string) {
            return "";
        }
    }

    private static final class BoundedRange implements Range {

        private final int from;
        private final int to;

        BoundedRange(int from, int i) {
            this.from = from;
            to = i;
        }

        @Override
        public int length() {
            return to - from;
        }

        @Override
        public String substring(String string) {
            return string.substring(from, to);
        }
    }

    private static final class Frequencies {

        private final Map<Character, Integer> map = new HashMap<>();

        static Frequencies from(String string) {
            var frequencies = new Frequencies();
            for (var i = 0; i < string.length(); i++) {
                frequencies.increment(string.charAt(i));
            }
            return frequencies;
        }

        void increment(char key) {
            map.put(key, frequency(key) + 1);
        }

        void decrement(char key) {
            map.put(key, frequency(key) - 1);
        }

        int frequency(char key) {
            return map.getOrDefault(key, 0);
        }

        boolean has(char key) {
            return map.containsKey(key);
        }

        int size() {
            return map.size();
        }
    }
}
