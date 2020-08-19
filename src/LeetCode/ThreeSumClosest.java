package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args){
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3},1));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int length = nums.length;
        for(int i = 0; i< length && diff !=0; ++i){
            int left = i + 1;
            int right = length - 1;
            while(left < right){
                int sum = nums[i] + nums[right] + nums[left];
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target-sum;
                }
                if(sum < target){
                    left++;
                } else {
                    right--;
                }
            }


        }
        return target - diff;
    }


}
