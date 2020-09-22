package labuladong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinCollecting {
    public static void main(String[] args){

    }

    public static int coinChange(int[] coins, int amount){
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return dp(amount, coins, memo);
    }

    public static int dp(int n, int[] coins, Map<Integer, Integer> memo){
        if (n==0) return 0;
        if (n<0) return -1;
        if (memo.get(n) != null) return memo.get(n);

        int res = Integer.MAX_VALUE;
        for(int i=0; i< coins.length; i++){
            int subproblem = dp(n-coins[i], coins, memo);
            if(subproblem == -1) continue;
            res = Math.min(res, 1+ subproblem);
        }
        memo.put(n,res!=Integer.MAX_VALUE? res : -1);
        return memo.get(n);
    }

    public static int coinChangeIterative(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.stream(dp).map((n) -> amount+1);

        dp[0] = 0;

       for(int i=0; i< dp.length; i++){
           for(int coin: coins){
               if(i - coin < 0) continue;
            dp[i] = Math.min(dp[i], 1+dp[i-coin]);
           }
       }
       return (dp[amount] == amount + 1) ? -1: dp[amount];

    }
}
