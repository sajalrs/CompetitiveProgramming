package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostCompetitiveSubsequence {
    static int[] min;
    static int[] mostCompetitive(int[] nums, int k) {
        min = null;
        int[] curArray = new int[k];
        generateSubsequences(nums, curArray, 0, 0, k);
        return min;
    }



    static void generateSubsequences(int[] nums, int[] curArray, int i, int j, int k){
        if(j < k && i < nums.length){
            generateSubsequences(nums, curArray, i+1,j, k);
            curArray[j] = nums[i];
            generateSubsequences(nums, curArray.clone(), i+1, j+1, k);
        }
        if(j == k){
            if(min == null){
                min = curArray.clone();
                return;
            }

            int index = 0;
            while(index < curArray.length){
                if(curArray[index] < min[index]){
                    min = curArray;
                    return;
                } else if(curArray[index] > min[index]){
                    return;
                } else {
                    index++;
                }
            }
            min = curArray;

        }
    }

    public static void main(String[] args){
        int[] array = {2,4,3,3,5,4,9,6};
        System.out.println(Arrays.toString(mostCompetitive(array,4)));
        int[] array2 = {3,5,2,6};
        System.out.println(Arrays.toString(mostCompetitive(array2,2)));

        int[] arr3 = {84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71};
        System.out.println(Arrays.toString(mostCompetitive(arr3,24)));
    }


}
