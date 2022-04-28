package Blind75;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] left = new int[nums.length+1];

        left[0] = nums[0];
        int maxSum = left[0];
        for(int i=1; i<nums.length; i++) {
            left[i] = Math.max(left[i-1] + nums[i], nums[i]);
            maxSum = Math.max(left[i], maxSum);
        }
        return maxSum;


    }

    public static void main(String[] args){
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{1}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{-2,-1}));
        System.out.println(maximumSubarray.maxSubArray(new int[]{-1}));
    }

}
