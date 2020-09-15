package LeetCode;

import java.util.Arrays;

public class ClimbingStairs {
    static int memo[];

    public static void main(String[] args){
        System.out.println(climbStairs(3));

    }


    public static int climbStairs(int n) {
        memo =  Arrays.stream(new int[n+1]).map(s->Integer.MIN_VALUE).toArray();
        memo[0] = 1;
        memo[1] = 1;
        for(int i=2; i< n+1; i++){
            dpBottomUp(i);
        }
        return memo[n];

    }

    public static int dpRecursive(int curStep){

        if(curStep< 0){
            return 0;
        }

        if(curStep == 0){
            return 1;
        }

        return dpRecursive(curStep - 1) + dpRecursive(curStep - 2);
    }

    public static int dpRecursiveWithMemo(int curStep){
        if(curStep < 0){
            return  0;
        }

        if(memo[curStep] != Integer.MIN_VALUE) return memo[curStep];
        int curValue = 0;


        curValue = dpRecursiveWithMemo(curStep - 1) + dpRecursiveWithMemo(curStep - 2);
        memo[curStep] = curValue;
        return curValue;
    }

    public static int dpBottomUp(int curStep){
        if(memo[curStep] != Integer.MIN_VALUE) return memo[curStep];
        int curValue = memo[curStep-1] + memo[curStep-2];
        memo[curStep] = curValue;
        return curValue;
    }



}
