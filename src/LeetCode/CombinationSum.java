package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations= new ArrayList<>();
        combinationSumHelper(candidates, target, 0, 0, combinations, new ArrayList<>());
        return combinations;
    }

    private void combinationSumHelper(int[] candidates, int target, int curSum, int i, List<List<Integer>> combinations, List<Integer> curCombination) {
        if (curSum > target || i >= candidates.length) {
            return;
        } else if (curSum == target) {
            if(!combinations.contains(curCombination)){
                combinations.add(curCombination);
            }

        } else {
            combinationSumHelper(candidates, target, curSum, i + 1, combinations, new ArrayList<>(curCombination));
            curCombination.add(candidates[i]);
            combinationSumHelper(candidates, target, curSum + candidates[i], i, combinations, new ArrayList<>(curCombination));
            combinationSumHelper(candidates, target, curSum + candidates[i], i + 1, combinations, new ArrayList<>(curCombination));
        }
    }
}
