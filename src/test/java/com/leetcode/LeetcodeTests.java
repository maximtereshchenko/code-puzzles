package com.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

    private TreeSet<TreeSet<String>> sorted(List<List<String>> lists) {
        return lists.stream()
                   .map(TreeSet::new)
                   .collect(Collectors.toCollection(() -> new TreeSet<>(this::compare)));
    }

    private int compare(TreeSet<String> first, TreeSet<String> second) {
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