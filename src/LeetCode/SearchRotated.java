package LeetCode;

public class SearchRotated {

    //first lets write a binary search algorithm
//we will be using a modified binary search
    static int binarySearch(int[] arr, int l, int r, int x) {
        if (l>=0 && r<arr.length && l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, l, mid - 1, x);
            }

            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }




    static int modifiedBinarySearch(int[] arr, int l, int r) {
        if (l>=0 && r<arr.length && l <= r) {
            int mid = l + (r - l) / 2;

            if (mid+1>0 && mid+1< arr.length && arr[mid] > arr[mid+1]) {
                return mid+1;
            } else{
                if(arr[mid] < arr[l]){
                    return modifiedBinarySearch(arr, l, mid-1);
                } else{
                    return modifiedBinarySearch(arr, mid+1, r);
                }

            }
        }
        return 0;
    }

    public static int search(int[] nums, int target) {

        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            } else{
                return -1;
            }
        }

       int pivot = modifiedBinarySearch(nums, 0, nums.length-1);
       int beforePivot = binarySearch(nums, 0, pivot-1, target);

       if(beforePivot == -1){
           int afterPivot = binarySearch(nums, pivot, nums.length-1, target);
           if(afterPivot != -1){
               return afterPivot;
           }
       } else {
           return beforePivot;
       }
       return -1;
    }

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(binarySearch(arr, 2));
//
//        int[] arr2 ={4,5,6,7,0,1,2};
//        System.out.println(search(arr2, 0));
//        System.out.println(search(arr2, 3));

        int[] arr3 = {1,3};
        System.out.println(search(arr3, 0));

    }
}
