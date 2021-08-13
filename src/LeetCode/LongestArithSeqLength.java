package LeetCode;

import java.util.*;

public class LongestArithSeqLength {


    List<Integer> maxList;
    public int longestArithSeqLength(int[] nums) {
        int maxLength = 0;

        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        if(nums.length == 2) return 2;

        Map<Integer, Map<Integer, Integer>> differences = new HashMap<>();

        for(int i=0; i<nums.length; i++) differences.put(i,new HashMap<>());

        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j< i; j++){
                int difference = nums[i]-nums[j];
                differences.get(i).put(difference, differences.get(j).getOrDefault(difference, 1) + 1);
                maxLength = Math.max(differences.get(i).get(difference), maxLength);
            }
        }

        return maxLength;
    }



}
