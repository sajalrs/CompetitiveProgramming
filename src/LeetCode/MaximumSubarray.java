package LeetCode;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args){
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));

    }

    public static int maxSubArray(int[] nums) {
        int[] memo = Arrays.stream(new int[nums.length]).map(s->Integer.MIN_VALUE).toArray();
        memo[0] = nums[0];
        int largestSum = memo[0];
        for(int i=1; i< nums.length; i++){
            memo[i] = Math.max(memo[i-1]+nums[i], nums[i]);
            largestSum = Math.max(memo[i], largestSum);
        }

        return largestSum;
    }
}
