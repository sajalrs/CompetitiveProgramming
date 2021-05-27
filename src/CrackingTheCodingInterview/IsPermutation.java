package CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

public class IsPermutation {

    public boolean isPermutation(String s1, String s2){
        Map<Character, Integer> occurrence = new HashMap<>();
        for(char c1: s1.toCharArray()){
            if(!occurrence.containsKey(c1)) {
                occurrence.put(c1, 1);
            } else {
                occurrence.put(c1, occurrence.get(c1) + 1);
            }
        }

        for(char c2:s2.toCharArray()){
            if(!occurrence.containsKey(c2)){
                return false;
            } else {
                occurrence.put(c2, occurrence.get(c2) - 1);
            }
        }

        for(char c: occurrence.keySet()){
            if(occurrence.get(c) != 0) return false;
        }

        return true;
    }
}
