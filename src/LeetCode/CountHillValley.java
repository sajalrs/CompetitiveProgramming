package LeetCode;

public class CountHillValley {
    public int countHillValley(int[] nums) {
        if (nums.length < 3) return 0;
        int left = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) continue;
            int right = nums[i + 1];
            if ((nums[i] > left && nums[i] > right) || nums[i] < left && nums[i] < right) count++;
            left = nums[i];
        }
        return count;
    }
}
