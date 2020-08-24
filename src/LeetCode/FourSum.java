package LeetCode;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length < 4){
            return res;
        }

        Arrays.sort(nums);
        int size = nums.length;
            for(int i =0; i< size;i++){
                for(int j=i+1; j< size; j++){
                    int left = j +1;
                    int right = size -1;

                    while(left < right){
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];

                        if(sum == target){
                            List<Integer> toAdd = new ArrayList<>();
                            toAdd.add(nums[i]);
                            toAdd.add(nums[j]);
                            toAdd.add(nums[left]);
                            toAdd.add(nums[right]);
                            res.add(toAdd);
                            int leftValue = nums[left];
                            while(left < size && nums[left] == leftValue){
                                ++left;
                            }

                            int rightValue = nums[right];
                            while(right > left && nums[right] == rightValue){
                                --right;
                            }

                        } else if(sum < target){
                            ++left;
                        } else {
                            --right;
                        }

                    }
                    while(j+1< size && nums[j+1] == nums[j]){
                        j++;
                    }

                    while(i+1< size && nums[i+1] == nums[i]){
                        i++;
                    }

                }
            }

        return res;


    }

    public static void main(String[] args){
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
