package com.leetcode;

//https://leetcode.com/problems/valid-palindrome
final class ValidPalindrome {

    boolean isPalindrome(String string) {
        for (
            int left = next(string, Direction.RIGHT),
                right = next(string, Direction.LEFT);
            left < right;
            left = next(string, left, Direction.RIGHT),
                right = next(string, right, Direction.LEFT)
        ) {
            if (lowerCased(string, left) != lowerCased(string, right)) {
                return false;
            }
        }
        return true;
    }

    private char lowerCased(String string, int left) {
        return Character.toLowerCase(string.charAt(left));
    }

    private int next(String string, Direction direction) {
        return next(string, direction.start(string), direction);
    }

    private int next(String string, int start, Direction direction) {
        var current = start;
        do {
            current += direction.vector();
        } while (shouldMove(string, current, direction));
        return current;
    }

    private boolean shouldMove(String string, int current, Direction direction) {
        if (current == direction.end(string)) {
            return false;
        }
        var character = string.charAt(current);
        return !(Character.isAlphabetic(character) || Character.isDigit(character));
    }

    private enum Direction {
        LEFT(-1) {
            @Override
            int start(String string) {
                return string.length();
            }

            @Override
            int end(String string) {
                return -1;
            }
        },
        RIGHT(1) {
            @Override
            int start(String string) {
                return LEFT.end(string);
            }

            @Override
            int end(String string) {
                return LEFT.start(string);
            }
        };

        private final int vector;

        Direction(int vector) {
            this.vector = vector;
        }

        int vector() {
            return vector;
        }

        abstract int start(String string);

        abstract int end(String string);
    }
}
