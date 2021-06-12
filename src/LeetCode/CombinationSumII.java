package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum2Helper(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }


    private void combinationSum2Helper(int[] candidates, int target, int i, List<Integer> curCombination, List<List<Integer>> combinations) {
        if(target < 0){
            return;
        } else if (target == 0){
            combinations.add(curCombination);
        } else {
            for(int j=i; j < candidates.length; j++){


                if(j == i || candidates[j] != candidates[j-1]){
                    curCombination.add(candidates[j]);
                    combinationSum2Helper(candidates, target - candidates[j],  j+1, new ArrayList<>(curCombination), combinations);
                    curCombination.remove(curCombination.size() - 1);

                }


            }



        }

    }


}
