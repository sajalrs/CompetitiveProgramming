package LeetCode;

import java.util.Arrays;

public class CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        if (nums.length < 4) return 0;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]) continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[k] < nums[j]) continue;
                    for(int l = k+1; l<nums.length;l++){
                        if(nums[i] + nums[j] + nums[k] == nums[l]) count++;
                    }
                }
            }
        }
        return count;
    }

}
