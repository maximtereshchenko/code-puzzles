package com.leetcode;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://leetcode.com/problems/group-anagrams
final class GroupAnagrams {

    List<List<String>> groupAnagrams(String[] strings) {
        return List.copyOf(
            Stream.of(strings)
                .collect(Collectors.groupingBy(this::letterOccurrences))
                .values()
        );
    }

    private Map<Integer, Long> letterOccurrences(String string) {
        return string.chars()
                   .boxed()
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
