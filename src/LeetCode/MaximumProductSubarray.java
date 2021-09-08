package LeetCode;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length;i++){
            int choice1 = maxProd * nums[i];
            int choice2 = minProd * nums[i];
            maxProd = Math.max(nums[i],Math.max(choice1,choice2));
            minProd = Math.min(nums[i],Math.min(choice1,choice2));
            max = Math.max(max, maxProd);
        }

        return max;
    }


}
