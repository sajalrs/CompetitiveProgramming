package LeetCode;

import DataStructuresAlgorithm.MergeSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountElements {
    public int countElements(int[] nums) {
        mergeSort(nums);
        int count = 2;
        for(int i =1; i<nums.length && nums[i] == nums[i-1];i++){
            count++;
        }

        for(int i=nums.length-2; i>0 && nums[i] == nums[i+1]; i--){
            count++;
        }

        return Math.max(nums.length - count,0);

    }

    private void mergeSort(int[] nums){
        mergeSortHelper(0, nums.length-1, nums);
    }

    private void mergeSortHelper(int l, int r, int[] nums){
        if(l<r){
            int m = (l+r)/2;
            mergeSortHelper(l, m, nums);
            mergeSortHelper(m+1, r, nums);
            merge(l, m,r, nums);
        }
    }

    private void merge(int l, int m, int r, int[] nums){

        int n1 = m-l+1;
        int n2 = r-m;


        int[] left = new int[n1];
        int[] right = new int[n2];

        int k = l;
        for(int i=0; i<n1; i++){
            left[i] = nums[k++];
        }

        for(int j=0; j<n2; j++){
            right[j] = nums[k++];
        }

        int i=0,j = 0;
        k = l;

        while(i<n1 && j <n2){
            if(left[i]<right[j]){
                nums[k] = left[i++];
            }else {
                nums[k] = right[j++];
            }
            k++;
        }

        while(i<n1){
            nums[k++] = left[i++];
        }


        while(j<n2){
            nums[k++] = right[j++];
        }

    }

    public static void main(String[] args){
        int[] nums = new int[]{50, -1, 4, 1,2,3};
        CountElements countElements = new CountElements();
        countElements.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
