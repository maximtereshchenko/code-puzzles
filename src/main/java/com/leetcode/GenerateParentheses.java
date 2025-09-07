package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses
final class GenerateParentheses {

    List<String> generateParenthesis(int total) {
        var parenthesis = new ArrayList<String>();
        generateParenthesis(parenthesis, "", 0, total);
        return parenthesis;
    }

    private void generateParenthesis(
        List<String> parenthesis,
        String prefix,
        int opened,
        int remaining
    ) {
        if (remaining > 0) {
            generateParenthesis(
                parenthesis,
                prefix + '(',
                opened + 1,
                remaining - 1
            );
        }
        if (opened > 0) {
            generateParenthesis(parenthesis, prefix + ')', opened - 1, remaining);
        }
        if (remaining == 0 && opened == 0) {
            parenthesis.add(prefix);
        }
    }
}
