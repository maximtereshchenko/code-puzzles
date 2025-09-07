package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.IntBinaryOperator;

//https://leetcode.com/problems/evaluate-reverse-polish-notation
final class EvaluateReversePolishNotation {

    int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();
        for (var token : tokens) {
            switch (token) {
                case "+" -> execute(stack, Integer::sum);
                case "-" -> execute(stack, (a, b) -> a - b);
                case "*" -> execute(stack, (a, b) -> a * b);
                case "/" -> execute(stack, (a, b) -> a / b);
                default -> stack.addLast(Integer.valueOf(token));
            }
        }
        return stack.getLast();
    }

    private void execute(Deque<Integer> stack, IntBinaryOperator operator) {
        var second = stack.removeLast();
        stack.addLast(operator.applyAsInt(stack.removeLast(), second));
    }
}
