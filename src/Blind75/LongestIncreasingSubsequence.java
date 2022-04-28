package Blind75;

import java.util.*;

public class LongestIncreasingSubsequence {

    public int lengthOfLISBrute(int[] nums) {

        return Math.max(lengthOfLISHelper(nums, 1, -1, 0),
                lengthOfLISHelper(nums, 1, 0, 1));
    }

    public int lengthOfLISHelper(int[] nums, int i, int lastAdded, int curLength) {
        if (i >= nums.length) {
            return curLength;
        }

        int returnValue = lengthOfLISHelper(nums, i + 1, lastAdded, curLength);
        int cur = nums[i];
        if (lastAdded == -1 || cur > nums[lastAdded]) {
            returnValue = Math.max(returnValue, lengthOfLISHelper(nums, i + 1, i, curLength + 1));
        }


        return returnValue;
    }

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1;
        int max = 1;

        for(int i= nums.length - 2; i>=0; i--){
            int curNum = nums[i];
            dp[i] = 1;
            for(int j=i+1; j<nums.length; j++){
                if(curNum < nums[j]) {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
