package LeetCode;

import java.util.Arrays;

public class MinimumRemoval {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int cur = 0;
        long minCount = Long.MAX_VALUE;
        long[] cumSum = new long[beans.length];
        cumSum[0] = beans[0];
        for(int i=1; i<beans.length;i++){
            cumSum[i] = cumSum[i-1] + beans[i];
        }
        while (cur < beans.length)
        {
            long count = 0;
            count+= cumSum[beans.length-1] - ((beans.length-cur) * (long) beans[cur]);
            minCount = Math.min(minCount, count);
            cur++;
        }
        return minCount;
    }
}
