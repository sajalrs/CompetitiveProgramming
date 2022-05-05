package CrackingTheCodingInterview;

public class Coins {
    public int coins(int n){
        int[] coins = new int[]{25,10,5,1};
        int[][] dp = new int[n+1][4];
        return coinsHelper(n, coins,dp, 0);
    }

    public int coinsHelper(int n,int[] coins,int[][] dp, int i){
        if(dp[n][i] !=0) return dp[n][i];
        int coin = coins[i];
        if(i == coins.length-1){
            int rem = n%coin;
            dp[n][i] = rem == 0? 1: 0;
            return dp[n][i];
        }
        int ways = 0;
        for(int amount =0; amount<=n; amount+=coin){
            ways+=coinsHelper(n - amount, coins,dp, i+1);
        }
        dp[n][i] = ways;
        return  dp[n][i];
    }

    public static void main(String[] args){
        Coins coins = new Coins();
        System.out.println(coins.coins(1));
        System.out.println(coins.coins(10));
    }
}
