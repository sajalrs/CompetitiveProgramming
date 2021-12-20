package LeetCode;

import java.util.*;

public class GetDescentPeriods {
    public long getDescentPeriodsBFS(int[] prices) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) graph.get(i-1).add(i);
        }
        return bfs(graph);
    }

    public long getDescentPeriods(int[] prices){
        long[] dp = new long[prices.length];
        dp[0] = 1;
        for(int i = 1; i<prices.length; i++){
            if(prices[i-1] - prices[i] == 1){
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        long sum = 0;
        for(int i=0; i<dp.length; i++){
            sum+= dp[i];
        }
        return sum;
    }

    private long bfs(List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < graph.size(); i++) {
            queue.add(i);
        }
        int descentPeriods = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            descentPeriods++;
            for (int index : graph.get(curNode)) {
                queue.add(index);
            }
        }
        return descentPeriods;
    }
}
