package LeetCode;

import java.util.Arrays;

public class FirstAndLastPosition {

    static int binarySearch(int[] arr, int l, int r, int x) {
        if (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                return binarySearch(arr, mid + 1, r, x);
            }

            return binarySearch(arr, l, mid - 1, x);

        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int arrPos = binarySearch(nums, 0, nums.length - 1, target);
        int[] toReturn;
        if (arrPos == -1) {
            toReturn = new int[]{-1, -1};
        } else {
            int l = arrPos;
            int r = arrPos;

            while(l>0 && nums[l-1] == target){
                l--;
            }

            while(r< nums.length -1 && nums[r+1] == target){
                r++;
            }

            toReturn = new int[]{l, r};
        }
        return toReturn;
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr1, 8)));
        System.out.println(Arrays.toString(searchRange(arr1, 6)));
        int[] arr2 = new int[]{2,2};
        System.out.println(Arrays.toString(searchRange(arr2, 2)));
        int[] arr3 = new int[]{1,1,2};
        System.out.println(Arrays.toString(searchRange(arr3, 1)));

    }


}
