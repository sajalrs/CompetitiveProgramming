package Blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for(int i=0; i<text1.length()+1; i++){
            dp.put(i, new HashMap<>());
        }
        return longestCommonSubsequenceHelper(0, 0, text1, text2, dp);
    }

    public int longestCommonSubsequenceHelper(int i, int j, String text1, String text2, Map<Integer, Map<Integer, Integer>> dp) {
        if(dp.containsKey(i) && dp.get(i).containsKey(j)) return dp.get(i).get(j);
        if (i >= text1.length() || j >= text2.length()) {
            dp.get(i).put(j, 0);
            return 0;
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp.get(i).put(j, 1 + longestCommonSubsequenceHelper(i + 1, j + 1, text1, text2, dp));
            return dp.get(i).get(j);
        }

        dp.get(i).put(j, Math.max(longestCommonSubsequenceHelper(i + 1, j, text1, text2, dp), longestCommonSubsequenceHelper(i, j + 1, text1, text2, dp)));
        return dp.get(i).get(j);
    }

    public static void main(String[] args){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "def"));
    }
}
