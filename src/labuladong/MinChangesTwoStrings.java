package labuladong;

import java.util.HashMap;
import java.util.Map;

public class MinChangesTwoStrings {

    public int minDistance(String s1, String s2){
        return dpRecursive(s1, s2 , s1.length() -1, s2.length() -1);
    }

    public int dpRecursive(String s1, String s2, int i, int j){
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;

        if(s1.charAt(i) == s2.charAt(j))
            return dpRecursive(s1, s2, i-1, j-1); //Skip
        else {
            return Math.min(
                    dpRecursive(s1,s2, i, j-1) + 1, //insert
                    Math.min(dpRecursive(s1,s2, i-1, j) + 1, //delete
                    dpRecursive(s1, s2, i-1, j-1) + 1) //replace
            );
        }
    }


    Map<String, Integer> memo = new HashMap<String, Integer>();
    public int dpWithMemo(String s1, String s2, int i, int j){
        String key = String.format("%d%d",i,j);
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(i == -1) return j + 1;
        if(j == -1) return i + 1;

        if(s1.charAt(i) == s2.charAt(j))
            memo.put(key,dpWithMemo(s1, s2, i-1, j-1)); //Skip
        else {
            memo.put(key,Math.min(
                    dpWithMemo(s1,s2, i, j-1) + 1, //insert
                    Math.min(dpWithMemo(s1,s2, i-1, j) + 1, //delete
                            dpWithMemo(s1, s2, i-1, j-1) + 1) //replace
            ));
        }
        return memo.get(key);
    }

    public int dpTopDown(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i< m;i++){
            dp[i][0] = i;
        }

        for(int j=1; j<=n; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <=m;i++){
            for(int j=1; j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(
                            dp[i-1][j] +1,
                            Math.min(dp[i][j-1] +1,
                            dp[i-1][j-1] + 1)
                    );
                }
            }
        }

        return dp[m][n];
    }

}
