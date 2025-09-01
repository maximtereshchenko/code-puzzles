package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-sudoku
final class ValidSudoku {

    boolean isValidSudoku(char[][] board) {
        var rows = new HashMap<Integer, Set<Integer>>();
        var columns = new HashMap<Integer, Set<Integer>>();
        var squares = new HashMap<Integer, Set<Integer>>();
        for (var row = 0; row < board.length; row++) {
            for (var column = 0; column < board[row].length; column++) {
                if (!isUnique(board[row][column], row, column, rows, columns, squares)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isUnique(
        char current,
        int row,
        int column,
        Map<Integer, Set<Integer>> rows,
        Map<Integer, Set<Integer>> columns,
        Map<Integer, Set<Integer>> squares
    ) {
        if (current == '.') {
            return true;
        }
        var digit = Character.digit(current, 10);
        return isUnique(digit, row, rows) &&
                   isUnique(digit, column, columns) &&
                   isUnique(digit, row - row % 3 + column / 3, squares);
    }

    private boolean isUnique(int digit, int key, Map<Integer, Set<Integer>> previous) {
        return previous.computeIfAbsent(key, ignored -> new HashSet<>()).add(digit);
    }
}
