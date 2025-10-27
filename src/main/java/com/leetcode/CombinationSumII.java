package com.leetcode;

import java.util.*;

//https://leetcode.com/problems/combination-sum-ii
final class CombinationSumII {

    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        var result = new ArrayList<List<Integer>>();
        combinationSum(new ArrayList<>(), candidates, 0, target, new HashMap<>(), result);
        return result;
    }

    private void combinationSum(
        List<Integer> current,
        int[] candidates,
        int index,
        int remaining,
        Map<Integer, Integer> ends,
        List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(List.copyOf(current));
            return;
        }
        if (remaining < 0 || index == candidates.length) {
            return;
        }
        var candidate = candidates[index];
        current.add(candidate);
        combinationSum(
            current,
            candidates,
            index + 1,
            remaining - candidate,
            ends,
            result
        );
        current.removeLast();
        combinationSum(
            current,
            candidates,
            ends.computeIfAbsent(candidate, key -> nextCandidateIndex(candidates, key, index)),
            remaining,
            ends,
            result
        );
    }

    private int nextCandidateIndex(int[] candidates, int candidate, int start) {
        for (var i = start; i < candidates.length; i++) {
            if (candidates[i] != candidate) {
                return i;
            }
        }
        return candidates.length;
    }
}
