package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {

        Map<Integer, Long> sumTilNow = new HashMap<>();
        Map<Integer, Long> countTilNow = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int curNum = arr[i];
            sumTilNow.put(curNum, 0l);
            countTilNow.put(curNum, 0l);
        }

        long[] intervals = new long[arr.length];

        for(int i=0; i<arr.length; i++){
            int curNum = arr[i];
            long curSum = sumTilNow.get(curNum);
            long curCount = countTilNow.get(curNum);
            intervals[i]+= (curCount * (long) i) - curSum;
            sumTilNow.put(curNum, curSum+i);
            countTilNow.put(curNum, curCount+1l);
        }

        for(int i=0; i<arr.length; i++){
            int curNum = arr[i];
            sumTilNow.put(curNum, 0l);
            countTilNow.put(curNum, 0l);
        }

        for(int i= arr.length-1; i>=0; i--){
            int curNum = arr[i];
            long curSum = sumTilNow.get(curNum);
            long curCount = countTilNow.get(curNum);
            intervals[i]+= curSum - (curCount * (long) i);
            sumTilNow.put(curNum, curSum+i);
            countTilNow.put(curNum, curCount+1l);
        }

        return intervals;
    }
}
