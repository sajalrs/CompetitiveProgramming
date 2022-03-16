package LeetCode;

public class MaximumTop {
    public int maximumTop(int[] nums, int k) {
        //Cant make any moves return top most
        if(k == 0) return nums[0];

        //If even you can just pop and push until top element is element numero uno.
        // If odd then you run out of moves but still one element left. Can't do nothing then
        if(k % 2 != 0 && nums.length == 1){
            return -1;
        }

        //Can onlY make one move which is pop. Top of stack is max possible
        if(k == 1) return nums[1];

        //After removing k-1 elements you can put down any of the k-1 elements or pop another. The item at tos would be max then
        if(k < nums.length){
            return Math.max(getMax(nums, 0, k-1), nums[k]);
        }

        //remove all elements would take k steps and we're out. Instead take k-1 elements out. We have to put one back otherwise we'd need to take out.
        if(k == nums.length){
            return getMax(nums, 0, k-1);
        }

        //we can remove all nums and put back pop whatever to put anything on top
        return getMax(nums, 0, nums.length);
    }

    private int getMax(int[] nums, int i, int j){
        if(nums.length == 0) return -1;
        int max = nums[i];
        i++;
        for(;i<j;i++){
            int cur = nums[i];
            max = Math.max(cur, max);
        }
        return max;
    }
}
