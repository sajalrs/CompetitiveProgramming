package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        Map<Integer, Map<Integer,Integer>> productsOfSubarrays = new HashMap();
        int maxProduct = nums[0];
        for(int i = 0; i<nums.length;i++){
            for(int j=0; j<nums.length; j++){
                maxProduct = Math.max(maxProduct, productOfSubarray(i, j, productsOfSubarrays, nums));
            }
        }
        return maxProduct;
    }

    public int productOfSubarray(int start, int end, Map<Integer,Map<Integer,Integer>> productsOfSubarrays, int[] nums){
        if(start < 0 && end >= nums.length ) return 0;

        if(productsOfSubarrays.containsKey(start) && productsOfSubarrays.get(start).containsKey(end)){
            return productsOfSubarrays.get(start).get(end);
        }

        int toReturn;
        if(start == end){
            toReturn = nums[start];
        } else if(start < end && start + 1 < nums.length){
            toReturn = nums[start] * productOfSubarray(start+1, end, productsOfSubarrays, nums);
        } else {
            toReturn = 0;
        }

        if(productsOfSubarrays.containsKey(start)){
            productsOfSubarrays.get(start).put(end,toReturn);
        }else {
            Map<Integer,Integer> toPut = new HashMap<>();
            toPut.put(end, toReturn);
            productsOfSubarrays.put(start, toPut);
        }
        return toReturn;

    }
}
