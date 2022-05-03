package CrackingTheCodingInterview;

import java.util.*;

public class PermutationWithoutDups {
    List<String> getPerms(String s){
        List<String> returnValue = new ArrayList<>();
        getPerms(buildFreqTable(s), "", s.length(), returnValue);
        return returnValue;
    }

    Map<Character, Integer> buildFreqTable(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }
        return map;
    }

    void getPerms(Map<Character, Integer> map, String prefix, int remaining, List<String> result){
        if(remaining == 0){
            result.add(prefix);
            return;
        }

        for(Character c: map.keySet()){
            int count = map.get(c);
            if(count > 0){
                map.put(c, count-1);
                getPerms(map, prefix+c, remaining-1, result);
                map.put(c, count);
            }
        }
    }

    public static void main(String[] args){
        PermutationWithoutDups permutationWithoutDups = new PermutationWithoutDups();
        for(String s: permutationWithoutDups.getPerms("aja")){
            System.out.println(s);
        }
    }
}
