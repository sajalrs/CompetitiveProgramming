package LeetCode;

public class MaxAscendingSum {
    private int curMax = 0;
    public int maxAscendingSum(int[] nums) {
        maxAscendingSumHelper(nums, 0, 0, 0);
        return curMax;
    }

    private void maxAscendingSumHelper(int[] nums, int i, int lastAdded, int sum){
        if(sum > curMax){
            curMax = sum;
        }

        if(i >= nums.length){
            return;
        }

        int curNum = nums[i];
        if(curNum >= nums[lastAdded] && lastAdded == i-1){
            maxAscendingSumHelper(nums, i+1, i, sum + curNum);
        }
        maxAscendingSumHelper(nums, i+1, i, curNum);
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{10,20,30,5,10,50};
        MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
        System.out.println(maxAscendingSum.maxAscendingSum(arr1));
    }
}
