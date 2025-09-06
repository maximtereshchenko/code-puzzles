package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

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