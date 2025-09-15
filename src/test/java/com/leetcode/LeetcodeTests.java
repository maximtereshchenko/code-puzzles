package com.leetcode;

import com.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

final class LeetcodeTests {

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Group Anagrams")
    void groupAnagrams(String[] strings, List<List<String>> expected) {
        assertThat(sorted(new GroupAnagrams().groupAnagrams(strings))).isEqualTo(sorted(expected));
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Top K Frequent Elements")
    void topKFrequent(int[] numbers, int k, int[] expected) {
        assertThat(new TopKFrequentElements().topKFrequent(numbers, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Encode and Decode Strings")
    void encodeAndDecodeStrings(List<String> strings) {
        var solution = new EncodeAndDecodeStrings();
        assertThat(solution.decode(solution.encode(strings))).isEqualTo(strings);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Product of Array Except Self")
    void productExceptSelf(int[] numbers, int[] expected) {
        assertThat(new ProductOfArrayExceptSelf().productExceptSelf(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Valid Sudoku")
    void isValidSudoku(char[][] board, boolean expected) {
        assertThat(new ValidSudoku().isValidSudoku(board)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Longest Consecutive Sequence")
    void longestConsecutive(int[] numbers, int expected) {
        assertThat(new LongestConsecutiveSequence().longestConsecutive(numbers))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Valid Palindrome")
    void isPalindrome(String string, boolean expected) {
        assertThat(new ValidPalindrome().isPalindrome(string)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Two Sum II - Input Array Is Sorted")
    void twoSum(int[] numbers, int target, int[] expected) {
        assertThat(new TwoSumInputArrayIsSorted().twoSum(numbers, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("3Sum")
    void threeSum(int[] numbers, List<List<Integer>> expected) {
        assertThat(sorted(new ThreeSum().threeSum(numbers))).isEqualTo(sorted(expected));
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Container With Most Water")
    void maxArea(int[] height, int expected) {
        assertThat(new ContainerWithMostWater().maxArea(height)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Trapping Rain Water")
    void trap(int[] height, int expected) {
        assertThat(new TrappingRainWater().trap(height)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Best Time to Buy and Sell Stock")
    void maxProfit(int[] prices, int expected) {
        assertThat(new BestTimeToBuyAndSellStock().maxProfit(prices)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Longest Substring Without Repeating Characters")
    void lengthOfLongestSubstring(String string, int expected) {
        assertThat(
            new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring(string)
        )
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Longest Repeating Character Replacement")
    void characterReplacement(String string, int maxReplacements, int expected) {
        assertThat(
            new LongestRepeatingCharacterReplacement()
                .characterReplacement(string, maxReplacements)
        )
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Permutation in String")
    void checkInclusion(String source, String target, boolean expected) {
        assertThat(new PermutationInString().checkInclusion(source, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Minimum Window Substring")
    void minWindow(String string, String pattern, String expected) {
        assertThat(new MinimumWindowSubstring().minWindow(string, pattern)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Sliding Window Maximum")
    void maxSlidingWindow(int[] numbers, int windowSize, int[] expected) {
        assertThat(new SlidingWindowMaximum().maxSlidingWindow(numbers, windowSize))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Valid Parentheses")
    void isValid(String string, boolean expected) {
        assertThat(new ValidParentheses().isValid(string)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Min Stack")
    void minStack(List<String> commands, List<List<Integer>> arguments, List<Integer> expected) {
        var actual = new ArrayList<Integer>();
        MinStack minStack = null;
        for (var i = 0; i < commands.size(); i++) {
            actual.add(
                switch (commands.get(i)) {
                    case "MinStack" -> {
                        minStack = new MinStack();
                        yield null;
                    }
                    case "push" -> {
                        minStack.push(arguments.get(i).getFirst());
                        yield null;
                    }
                    case "pop" -> {
                        minStack.pop();
                        yield null;
                    }
                    case "top" -> minStack.top();
                    case "getMin" -> minStack.getMin();
                    default -> throw new IllegalArgumentException();
                }
            );
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Evaluate Reverse Polish Notation")
    void evalRPN(String[] tokens, int expected) {
        assertThat(new EvaluateReversePolishNotation().evalRPN(tokens)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Generate Parentheses")
    void generateParenthesis(int total, List<String> expected) {
        assertThat(new GenerateParentheses().generateParenthesis(total)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Daily Temperatures")
    void dailyTemperatures(int[] temperatures, int[] expected) {
        assertThat(new DailyTemperatures().dailyTemperatures(temperatures)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Car Fleet")
    void carFleet(int target, int[] positions, int[] speeds, int expected) {
        assertThat(new CarFleet().carFleet(target, positions, speeds)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Largest Rectangle in Histogram")
    void largestRectangleArea(int[] heights, int expected) {
        assertThat(new LargestRectangleInHistogram().largestRectangleArea(heights))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Binary Search")
    void search(int[] numbers, int target, int expected) {
        assertThat(new BinarySearch().search(numbers, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Search a 2D Matrix")
    void searchMatrix(int[][] matrix, int target, boolean expected) {
        assertThat(new Search2DMatrix().searchMatrix(matrix, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Koko Eating Bananas")
    void minEatingSpeed(int[] piles, int hours, int expected) {
        assertThat(new KokoEatingBananas().minEatingSpeed(piles, hours)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Find Minimum in Rotated Sorted Array")
    void findMin(int[] numbers, int expected) {
        assertThat(new FindMinimumInRotatedSortedArray().findMin(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Search in Rotated Sorted Array")
    void searchInRotatedSortedArray(int[] numbers, int target, int expected) {
        assertThat(new SearchInRotatedSortedArray().search(numbers, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Time Based Key-Value Store")
    void timeBasedKeyValueStore(
        List<String> commands,
        List<List<Object>> arguments,
        List<Integer> expected
    ) {
        var actual = new ArrayList<String>();
        TimeBasedKeyValueStore timeBasedKeyValueStore = null;
        for (var i = 0; i < commands.size(); i++) {
            actual.add(
                switch (commands.get(i)) {
                    case "TimeMap" -> {
                        timeBasedKeyValueStore = new TimeBasedKeyValueStore();
                        yield null;
                    }
                    case "set" -> {
                        var commandArguments = arguments.get(i);
                        timeBasedKeyValueStore.set(
                            (String) commandArguments.get(0),
                            (String) commandArguments.get(1),
                            (int) commandArguments.get(2)
                        );
                        yield null;
                    }
                    case "get" -> {
                        var commandArguments = arguments.get(i);
                        yield timeBasedKeyValueStore.get(
                            (String) commandArguments.get(0),
                            (int) commandArguments.get(1)
                        );
                    }
                    default -> throw new IllegalArgumentException();
                }
            );
        }
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Median of Two Sorted Arrays")
    void findMedianSortedArrays(int[] numbers1, int[] numbers2, double expected) {
        assertThat(new MedianOfTwoSortedArrays().findMedianSortedArrays(numbers1, numbers2))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Reverse Linked List")
    void reverseList(ListNode head, ListNode expected) {
        assertThat(new ReverseLinkedList().reverseList(head)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ArgumentsSource(LeetcodeArgumentsProvider.class)
    @DisplayName("Merge Two Sorted Lists")
    void mergeTwoLists(ListNode list1, ListNode list2, ListNode expected) {
        assertThat(new MergeTwoSortedLists().mergeTwoLists(list1, list2)).isEqualTo(expected);
    }

    private <T extends Comparable<T>> List<List<T>> sorted(List<List<T>> lists) {
        return lists.stream()
                   .map(list -> list.stream().sorted().toList())
                   .sorted(this::compare)
                   .toList();
    }

    private <T extends Comparable<T>> int compare(List<T> first, List<T> second) {
        var firstIterator = first.iterator();
        var secondIterator = second.iterator();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            var comparison = firstIterator.next().compareTo(secondIterator.next());
            if (comparison != 0) {
                return comparison;
            }
        }
        if (firstIterator.hasNext()) {
            return 1;
        }
        if (secondIterator.hasNext()) {
            return -1;
        }
        return 0;
    }
}