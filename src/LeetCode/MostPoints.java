package LeetCode;

import java.util.*;

public class MostPoints {
    public long mostPoints(int[][] questions) {

        Map<Integer, Long> pointsSoFar = new HashMap<>();
        for(int i=0; i<questions.length; i++){
            pointsSoFar.put(i, 0l);
        }

        for(int i = 0; i<questions.length; i++){
            int nextQuestion = i + questions[i][1] + 1;
            if(pointsSoFar.containsKey(nextQuestion)){
                pointsSoFar.put(nextQuestion, Math.max(pointsSoFar.get(nextQuestion), pointsSoFar.get(i)+questions[i][0]));
            }else {
                pointsSoFar.put(nextQuestion, pointsSoFar.get(i)+questions[i][0]);
            }
        }

        for(int i=0; i<questions.length; i++){
            pointsSoFar.put(i, pointsSoFar.get(i)+questions[i][0]);
        }

        long max = 0l;
        for(int i=0; i<questions.length; i++){
            max = Math.max(max, pointsSoFar.get(i));
        }
        return max;
    }

    public long mostPointsDFS(int[][] questions) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int i =0; i<questions.length; i++){
            if(!graph.containsKey(i)){
                graph.put(i, new HashMap<>());
            }

            Map<Integer, Integer> vertices = graph.get(i);

            vertices.put(i+1, 0);
            vertices.put(i+questions[i][1]+1, questions[i][0]);
        }
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<questions.length; i++){
            stack.add(new int[]{i,0});
        }
        int max = 0;
        while (!stack.isEmpty()){

            int[] curNode = stack.pop();
            if(curNode[0] < questions.length){
                Set<Integer> adjacentNodes = graph.get(curNode[0]).keySet();
                for(int node: adjacentNodes){
                    stack.add(new int[]{node, curNode[1] + graph.get(curNode[0]).get(node)});
                }
            } else {
                max = Math.max(max, curNode[1]);
            }
        }
        return max;
    }
}
