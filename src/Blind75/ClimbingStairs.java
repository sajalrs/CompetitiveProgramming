package Blind75;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public int climbStairs(int n) {
        return climbStairsHelper(n, new HashMap<>());
    }

    public int climbStairsHelper(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) return dp.get(n);
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int noOfWays = climbStairsHelper(n - 1, dp) +
                climbStairsHelper(n - 2, dp);
        dp.put(n, noOfWays);
        return noOfWays;
    }

    public static void main(String[] args){
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
    }
}
