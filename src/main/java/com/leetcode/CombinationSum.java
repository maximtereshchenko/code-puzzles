package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum
final class CombinationSum {

    List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        combinationSum(new ArrayList<>(), candidates, 0, target, result);
        return result;
    }

    private void combinationSum(
        List<Integer> current,
        int[] candidates,
        int index,
        int remaining,
        List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(List.copyOf(current));
            return;
        }
        if (remaining < 0 || index == candidates.length) {
            return;
        }
        current.add(candidates[index]);
        var nextRemaining = remaining - candidates[index];
        combinationSum(current, candidates, index, nextRemaining, result);
        current.removeLast();
        combinationSum(current, candidates, index + 1, remaining, result);
    }
}
