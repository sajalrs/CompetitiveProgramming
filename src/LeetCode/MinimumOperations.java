package LeetCode;

import java.util.Arrays;

public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        if(nums.length <= 1) return 0;
        if(nums.length == 2) return nums[0] == nums[1]? 1: 0;

        int[] even = new int[nums.length%2 == 0? nums.length/2: nums.length/2 + 1];
        int[] odd = new int[nums.length/2];

        int i=0, j=0;
        for(int k=0; k<nums.length;k++){
            if(k%2==0){
                even[i++] = nums[k];
            }else {
                odd[j++] = nums[k];
            }
        }

        Arrays.sort(even);
        Arrays.sort(odd);

        int[] maxRecurringEven = countMaxRecurring(even, -1);
        int[] maxRecurringOdd= countMaxRecurring(odd, -1);

        if(maxRecurringEven[0] == maxRecurringOdd[0]){
            if(maxRecurringEven[1] > maxRecurringOdd[1]){
                maxRecurringOdd = countMaxRecurring(odd, maxRecurringOdd[0]);
            } else {
                maxRecurringEven = countMaxRecurring(even, maxRecurringEven[0]);
            }
        }
        return (even.length - maxRecurringEven[1]) + (odd.length - maxRecurringOdd[1]);
    }

    private int[] countMaxRecurring(int[] array, int exempt){
        int prev = array[0];
        int max = exempt == prev? 0: 1;
        int num = prev;
        int localMax = exempt == prev? 0: 1;
        for(int i=1; i<array.length; i++){
            int cur = array[i];
            if(prev == cur && cur!=exempt){
                localMax++;
            } else{
                if(localMax > max){
                    max = localMax;
                    num = prev;
                }
                localMax = exempt == cur? 0: 1;;
            }
            prev = cur;
        }
        if(localMax > max){
            max = localMax;
            num = prev;
        }
        return new int[]{num, max};
    }
}
