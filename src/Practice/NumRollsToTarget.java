package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumRollsToTarget {
    public class Count{
        int value  = 0;
    }
    int M= (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        Count count = new Count();
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        numRollsToTargetHelper(n, k, target, count, dp );
        return count.value;
    }
    public void numRollsToTargetHelper(int n, int k, int target, Count count, Map<Integer, Map<Integer, Integer>> dp) {
        if(dp.containsKey(n) && dp.get(n).containsKey(target)){
            count.value+=dp.get(n).get(target);
            count.value%=M;
            return;
        }

        if(n<0){
            return;
        }
        if(n==0){
            if(target == 0){
                count.value++;
                count.value%=M;
            }
            return;
        }

        for(int i=1; i<=k; i++){
            Count localCount = new Count();
            numRollsToTargetHelper(n-1, k, target-i, localCount, dp);
            dp.computeIfAbsent(n-1, key -> new HashMap<>()).put(target-i, localCount.value);
            count.value+=localCount.value;
            count.value%=M;
        }
    }


    public static void main(String[] args){
        NumRollsToTarget numRollsToTarget = new NumRollsToTarget();
        System.out.println(numRollsToTarget.numRollsToTarget(1,6,3));
        System.out.println(numRollsToTarget.numRollsToTarget(2,6,7));
        System.out.println(numRollsToTarget.numRollsToTarget(30,30,500));
    }
}
