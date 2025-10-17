package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets
final class Subsets {

    List<List<Integer>> subsets(int[] numbers) {
        var result = new ArrayList<List<Integer>>();
        subsets(new ArrayList<>(), numbers, 0, result);
        return result;
    }

    private void subsets(
        List<Integer> current,
        int[] numbers,
        int index,
        List<List<Integer>> result
    ) {
        if (index == numbers.length) {
            result.add(List.copyOf(current));
            return;
        }
        subsets(current, numbers, index + 1, result);
        current.add(numbers[index]);
        subsets(current, numbers, index + 1, result);
        current.removeLast();
    }
}
