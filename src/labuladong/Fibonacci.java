package labuladong;

public class Fibonacci {

    public static void main(String[] args){
        System.out.println(fib(5));
        System.out.println(fibBottomUp(5));
        System.out.println(optiFibBottomUp(5));
    }

    public static int fib(int N){
        if(N < 1) return 0;
        int[] memo = new int[N+1];
        return helper(memo, N);
    }

    public static int helper(int[] memo, int n){
        if(n == 1 || n==2) return 1;
        if(memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n-1) + helper(memo, n-2);
        return memo[n];
    }

    public static int fibBrute(int N){
        if(N==1 || N==2) return 1;
        return fibBrute(N-1) + fibBrute(N-2);
    }

    public static int fibBottomUp(int N){
        int[] dp = new int[N+1];
        dp[1] = dp[2] = 1;
        for(int i =3; i<= N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    public static int optiFibBottomUp(int n) {
        if(n==2 || n==1) return 1;
        int prev = 1, curr = 1;
        for(int i = 3; i<=n; i++){
            int sum = prev+ curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
