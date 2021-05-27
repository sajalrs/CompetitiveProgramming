package LeetCode;

import java.util.Arrays;

public class MinElements {




    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0, ans = 0;
        for(int num:nums) sum+=num;
        long diff = Math.abs(goal-sum);
        ans = (diff/Math.abs(limit));
        if(diff% Math.abs(limit) != 0) ans++;
        return (int) ans;
    }



    public static void main(String[] args){
        int[] array = new int[]{1,-1,1};
        MinElements minElements = new MinElements();

    }

}
