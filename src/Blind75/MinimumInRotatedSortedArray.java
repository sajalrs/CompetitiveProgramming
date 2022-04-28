package Blind75;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[nums.length-1]) return nums[0];
        return modifiedBinarySearch(nums, 0, nums.length-1);
    }

    public int modifiedBinarySearch(int[] nums, int l, int r){
        if(l<=r){
            int m = (l+r)/2;
            if(nums[m+1] < nums[m]){
                return nums[m+1];
            }

            if(nums[m] < nums[r]){
                return modifiedBinarySearch(nums, l, m);
            }

            return modifiedBinarySearch(nums, m, r);
        }
        return -1;
    }

    public static void main(String[] args){
        MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{3,4,5,1,2}));
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{11,13,15,17}));
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{1}));
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{2,1}));
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{2,3,1}));
        System.out.println(minimumInRotatedSortedArray.findMin(new int[]{3,1,2}));
    }
}
