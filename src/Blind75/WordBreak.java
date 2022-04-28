package Blind75;

import java.lang.reflect.Array;
import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0, new Boolean[s.length()]);
    }

    public boolean wordBreakHelper(String s, List<String> wordDict, int start, Boolean[] dp){
        if(start>=s.length()) return false;
        if(dp[start] != null) return dp[start];
        if(wordDict.contains(s.substring(start))) return true;

        for(int end=start+1; end<s.length(); end++){
            if(wordDict.contains(s.substring(start, end)) && wordBreakHelper(s, wordDict, end, dp)){
                dp[start] =true;
                return true;
            }
        }
        dp[start] = false;
        return false;
    }

    public static void main(String[] args){
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList(new String[]{"leet","code"})));
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList(new String[]{"apple","pen"})));
        System.out.println(wordBreak.wordBreak("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"})));
        System.out.println(wordBreak.wordBreak("a", Arrays.asList(new String[]{"a"})));
    }

}
