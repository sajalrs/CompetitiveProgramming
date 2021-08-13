package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> local = new ArrayList<>();
        List<Integer> remList = new LinkedList<>();
        for(int num: nums){
            remList.add(num);
        }

        recursive(nums, local, remList, list);

        for(List<Integer> subList : list){
            System.out.println(Arrays.toString(subList.toArray()));
        }
        return list;

    }

    private void recursive(int[] nums, List<Integer> local, List<Integer> remList, List<List<Integer>> permutations){
        if(local.size() == nums.length){
            permutations.add(local);
            return;
        }

        for(int i =0; i<remList.size();i++){
            List<Integer> remListCopy = new LinkedList<>(remList);
            List<Integer> localCopy = new ArrayList<>(local);
            localCopy.add(remListCopy.get(i));
            remListCopy.remove(i);
            recursive(nums, localCopy, remListCopy, permutations);
        }
    }
}
