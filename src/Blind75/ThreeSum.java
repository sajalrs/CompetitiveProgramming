package Blind75;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSumN3(int[] nums) {
        List<List<Integer>> returnValue = new ArrayList<>();
        Set<String> usedAlready = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i==j) continue;
                for(int k=0; k<nums.length; k++){
                    if(k==j || k==i) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    int[] arr = new int[]{nums[i], nums[j], nums[k]};
                    Arrays.sort(arr);
                    int num1 = arr[0];
                    int num2 = arr[1];
                    int num3 = arr[2];

                    stringBuilder.append(num1);
                    stringBuilder.append(num2);
                    stringBuilder.append(num3);
                    String key = stringBuilder.toString();
                    if(!usedAlready.contains(key) && (num1+num2+num3 == 0)){
                        List<Integer> sum = new ArrayList<>();
                        sum.add(num1);
                        sum.add(num2);
                        sum.add(num3);
                        returnValue.add(sum);
                        usedAlready.add(key);
                    }
                }
            }
        }
        return returnValue;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int curNum = nums[i];
            if(map.containsKey(curNum)) return new int[]{map.get(curNum), i};
            map.put(target - curNum, i);
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnValue = new ArrayList<>();
        Set<String> usedAlready = new HashSet<>();
        Arrays.sort(nums);
        for(int i=1; i<nums.length-1; i++){
            int left = i-1;
            int right = i+1;

            while(left>=0 && right<=nums.length-1){
                int sum = nums[left] + nums[i] + nums[right];
                if(sum == 0){
                    String key = String.format("%s%s%s", nums[left], nums[i], nums[right]);
                    if(!usedAlready.contains(key)){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[i]);
                        list.add(nums[right]);
                        returnValue.add(list);
                        usedAlready.add(key);
                    }
                    left--;
                    right++;
                }else {
                    if(sum<0){
                        right++;
                    }

                    if(sum > 0){
                        left--;
                    }
                }
            }
        }
        return returnValue;
    }

    public static void main(String[] args){
        ThreeSum threeSum = new ThreeSum();
        for(List<Integer> list: threeSum.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4})){
            for(int i: list){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
