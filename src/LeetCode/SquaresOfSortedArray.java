package LeetCode;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        if(nums.length == 1) return new int[]{(int) Math.pow(nums[0], 2)};

        int zeroPos = binarySearch(0, nums.length - 1, nums);
        int[] squaresArray = new int[nums.length];
        for(int i=0; i<nums.length;i++){
            nums[i] = (int) Math.pow(nums[i],2);
        }

        int i = zeroPos - 1, j = zeroPos;
        int k = 0;

        while (i >= 0 && j < nums.length) {
            if (nums[i]< nums[j]) {
                squaresArray[k] = nums[i];
                k++;
                i--;
            } else {
                squaresArray[k] =  nums[j];
                k++;
                j++;
            }
        }

        while (i >= 0) {
            squaresArray[k] = nums[i];
            k++;
            i--;
        }

        while (j < nums.length) {
            squaresArray[k] = nums[j];
            k++;
            j++;
        }

        return squaresArray;
    }


    public int binarySearch(int l, int r, int[] nums) {
        if (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == 0) return m;

            if (nums[m] < 0) {
                return binarySearch(m + 1, r, nums);
            } else {
                return binarySearch(l, m - 1, nums);
            }
        }
        return l;
    }
}
