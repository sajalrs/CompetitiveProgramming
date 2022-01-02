package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntervalsBetweenIdenticalElements {
    public long[] getDistances(int[] arr) {

        Map<Integer, List<Integer>> numbersAtPos = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            numbersAtPos.put(arr[i], new ArrayList<>());
        }

        for(int i=0; i<arr.length; i++){
            int curNum = arr[i];
            numbersAtPos.get(curNum).add(i);
        }

        long[] intervals = new long[arr.length];
        for(int i =0; i<arr.length; i++){
            long sumOfIntervals = 0;
            for(int occurrence: numbersAtPos.get(arr[i])){
                sumOfIntervals+=Math.abs(i-occurrence);
            }
            intervals[i] = sumOfIntervals;
        }

        return intervals;
    }
}
