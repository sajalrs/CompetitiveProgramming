package LeetCode;

import java.util.Arrays;

public class MinimalKSum {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        for(int i=1; i<nums[0] && k>0; i++){
            sum+=i;
            k--;
        }
        int prev = nums[0];

        for(int j=1; j<nums.length && k>0;j++){
            int cur = nums[j];
            if(prev != cur){
                for(int i=prev+1; i<cur && k>0; i++){
                   sum+=i;
                   k--;
                }
            }
            prev = cur;
        }

        for(int i=nums[nums.length-1] + 1; k>0; i++){
            sum+=i;
            k--;
        }
        return sum;
    }
}
