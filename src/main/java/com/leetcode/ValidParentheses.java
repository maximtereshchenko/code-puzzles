package com.leetcode;

import java.util.ArrayDeque;
import java.util.Map;

//https://leetcode.com/problems/valid-parentheses
final class ValidParentheses {

    private static final Map<Character, Character> BRACKETS = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    boolean isValid(String string) {
        var stack = new ArrayDeque<Character>();
        for (var i = 0; i < string.length(); i++) {
            var current = string.charAt(i);
            if (BRACKETS.containsKey(current)) {
                var opened = BRACKETS.get(current);
                if (stack.isEmpty() || !stack.getLast().equals(opened)) {
                    return false;
                }
                stack.removeLast();
            } else {
                stack.addLast(current);
            }
        }
        return stack.isEmpty();
    }
}
