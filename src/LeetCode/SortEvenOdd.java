package LeetCode;

import java.util.Arrays;

public class SortEvenOdd {
    public int[] sortEvenOdd(int[] nums) {
        if(nums.length <= 2){
            return nums;
        }

        int[] even = nums.length %2 == 0 ? new int[nums.length/2] : new int[nums.length/2 + 1];
        int[] odd = new int[nums.length/2];
        int i=0, j=0;
        for(int k=0; k<nums.length; k++){
            if(k%2 == 0){
                even[i++] = nums[k];
            } else {
                odd[j++] = nums[k];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd);
        i =0;
        j= odd.length -1;
        for(int k=0; k<nums.length;k++){
            if(k%2 == 0){
                nums[k] = even[i++];
            }else {
                nums[k] = odd[j--];
            }
        }
        return nums;
    }


}
