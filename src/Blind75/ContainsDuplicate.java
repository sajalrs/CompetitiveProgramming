package Blind75;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)) map.put(num,0);
            int freq = map.get(num);
            if(freq >= 1) return true;
            map.put(num, freq + 1);
        }
        return false;
    }

    public static void main(String[] args){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,1})? "Y": "N");
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4})? "Y": "N");
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})? "Y": "N");
    }
}
