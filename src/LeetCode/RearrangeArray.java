package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RearrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length/2;
        int[] positive = new int[n];
        int[] negative = new int[n];

        int i=0, j=0, k=0;
        while (k<nums.length){
            if(nums[k] < 0){
                negative[i++] = nums[k++];
            }else {
                positive[j++] = nums[k++];
            }
        }

        i=0;
        j=0;
        for(k=0; k<nums.length; k++){
            if(k%2==0){
                nums[k] = positive[i++];
            }else {
                nums[k] = negative[j++];
            }
        }

        return nums;
    }
}
