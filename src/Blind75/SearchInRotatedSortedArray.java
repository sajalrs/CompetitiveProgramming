package Blind75;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int startIndex = findMinIndex(nums);
        return binarySearch(nums, 0, nums.length - 1, startIndex, target);
    }

    public int binarySearch(int[] nums, int l, int r, int startIndex, int target) {
        if (l <= r) {
            int m = (l + r) / 2;
            int numAtM = getNumInRotatedArray(m, startIndex, nums);
            if (numAtM == target) {
                return indexToRotatedIndex(m, startIndex, nums.length);
            }

            if (numAtM > target) {
                return binarySearch(nums, l, m - 1, startIndex, target);
            }
            return binarySearch(nums, m + 1, r, startIndex, target);
        }
        return -1;
    }

    public int getNumInRotatedArray(int i, int startIndex, int[] nums) {
        if ((startIndex + i) <= nums.length - 1) return nums[startIndex + i];
        return nums[startIndex + i - nums.length];
    }

    public int indexToRotatedIndex(int index, int startIndex, int length){
        if(startIndex+index <= length-1) return startIndex+index;
        return startIndex+index-length;
    }


    public int findMinIndex(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] < nums[nums.length - 1]) return 0;
        return modifiedBinarySearch(nums, 0, nums.length - 1);
    }

    public int modifiedBinarySearch(int[] nums, int l, int r) {
        if (l <= r) {
            int m = (l + r) / 2;
            if (nums[m + 1] < nums[m]) {
                return m + 1;
            }

            if (nums[m] < nums[r]) {
                return modifiedBinarySearch(nums, l, m);
            }

            return modifiedBinarySearch(nums, m, r);
        }
        return -1;
    }

    public static void main(String[] args){
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(searchInRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2},3));
        System.out.println(searchInRotatedSortedArray.search(new int[]{1}, 0));

    }
}
