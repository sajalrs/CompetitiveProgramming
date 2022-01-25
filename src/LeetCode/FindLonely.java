package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLonely {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> friends = new HashMap<>();

        for(int num: nums){
            if(!friends.containsKey(num)){
                friends.put(num, 1);
            } else {
                friends.put(num, 2);
            }

            if(friends.containsKey(num+1)){
                friends.put(num, 2);
                friends.put(num+1, 2);
            }


            if(friends.containsKey(num-1)){
                friends.put(num, 2);
                friends.put(num-1, 2);
            }
        }

        List<Integer> lonely = new ArrayList<>();
        for(int num: friends.keySet()){
            if(friends.get(num) == 1) lonely.add(num);
        }

        return lonely;
    }
}
