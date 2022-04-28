package Blind75;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=0; i<=amount; i++){
            for(int coin: coins){
                if(coin<=i){
                    dp[i] = Math.min(dp[i], (1 + dp[i-coin]));
                }

            }
        }

        if(dp[amount] > amount) return -1;
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
        System.out.println(coinChange.coinChange(new int[]{1}, 0));
        System.out.println(coinChange.coinChange(new int[]{186,419,83,408}, 6249));
    }
}
