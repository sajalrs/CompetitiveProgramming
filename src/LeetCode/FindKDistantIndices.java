package LeetCode;

import java.util.*;

public class FindKDistantIndices {
    public List<Integer> findKDistantIndicesTrivial(int[] nums, int key, int k) {

        Set<Integer> kDistantIndices = new HashSet<>();
        for(int i=0; i<nums.length;i++){
            if(nums[i] == key){
                for(int j = Math.max(i - k, 0); j<= Math.min(i+k,nums.length-1);j++){
                    kDistantIndices.add(j);
                }
            }

        }

        List<Integer> toReturn = new ArrayList<>();
        for(int num: kDistantIndices){
               toReturn.add(num);
        }
        Collections.sort(toReturn);
        return toReturn;
    }
}
