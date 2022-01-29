package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String[] words) {
        Map<String, Map<Boolean, Integer>> pairs = new HashMap<>();
        for(String word: words){
            char[] charRep = word.toCharArray();
            Arrays.sort(charRep);
            String alphabetical = String.valueOf(charRep);

            if(pairs.containsKey(alphabetical)){
                boolean asc = alphabetical.equals(word);
                if(pairs.get(alphabetical).containsKey(asc)){
                    pairs.get(alphabetical).put(asc, pairs.get(alphabetical).get(asc) + 1);
                }else{
                    pairs.get(alphabetical).put(asc, 1);
                }
            } else{
                pairs.put(alphabetical, new HashMap<Boolean, Integer>());
                pairs.get(alphabetical).put(alphabetical.equals(word), 1);
            }
        }

        int sum = 0;
        int toAdd = 0;
        for(String pair: pairs.keySet()){
            if(pair.charAt(0) == pair.charAt(1)){
                int totalMatches = pairs.get(pair).get(true);
                int palindromeLengthIncrease = (totalMatches/2) * 2;
                toAdd = Math.max(toAdd, totalMatches%2);
                sum+= palindromeLengthIncrease;
            }else {
                int asc = pairs.get(pair).containsKey(true)? pairs.get(pair).get(true): 0;
                int des = pairs.get(pair).containsKey(false)? pairs.get(pair).get(false): 0;
                int palindromeLengthIncrease = Math.min(asc, des) *2;
                sum+= palindromeLengthIncrease;
            }
        }
        return (sum+toAdd)*2;
    }
}
