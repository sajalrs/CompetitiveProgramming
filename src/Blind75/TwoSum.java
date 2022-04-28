package Blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int curNum = nums[i];
            if(map.containsKey(curNum)) return new int[]{map.get(curNum), i};
            map.put(target - curNum, i);
        }
        return null;
    }

    public static void main(String[] args){
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,3}, 6)));

    }
}
