package LeetCode;

import DataStructuresAlgorithm.AllAlgos;

import java.util.*;

/*
    Algorithm:
    Sweep through 2D array.
    Form Map with Number as key and Numbers next to it as value (Adjacency Matrix)
    Iterate over Keys of HashMap
    Add Key to Array
    Iterate over Value Array
    Add Values[i] to Array while checking if prev is Values[i]
    Backtrack if Values not empty after adding
 */
public class RestoreArray {
    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs == null || adjacentPairs.length == 0 || adjacentPairs[0] == null || adjacentPairs[0].length == 0)
            return new int[0];

        Map<Integer, List<Edge>> graph = new HashMap();
        Map<Integer, Boolean> visited = new HashMap<>();
        for(int i=0; i<adjacentPairs.length;i++){
            int first = adjacentPairs[i][0];
            int second = adjacentPairs[i][1];
            if(!graph.containsKey(first)){
                graph.put(first, new LinkedList<>());
            }
            if(!graph.containsKey(second)){
                graph.put(second, new LinkedList<>());
            }
            if(!visited.containsKey(first)){
                visited.put(first, false);
            }
            if(!visited.containsKey(second)){
                visited.put(second, false);
            }

            graph.get(first).add(new Edge(first, second, 1));
            graph.get(second).add(new Edge(second, first,1));
        }


        List<Integer> toReturn = new LinkedList<>();
        dfs(getStart(graph), visited, graph, toReturn);
        return toReturn.stream().mapToInt(i -> i).toArray();
    }

    static void dfs(int at,  Map<Integer, Boolean> visited, Map<Integer, List<Edge>> graph, List<Integer> toReturn) {
        if (visited.get(at)) {
            return;
        }
        visited.put(at, true);
        List<Edge> edges = graph.get(at);
        toReturn.add(at);
        if (edges != null) {
            for (Edge edge : edges) {
                dfs(edge.to, visited, graph, toReturn);
            }
        }

    }

    static int getStart(Map<Integer, List<Edge>> graph){
        for(int start: graph.keySet()){
            if(graph.get(start).size() == 1){
                return start;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[][] array = new int[][]{new int[]{2, 1}, new int[]{3,4}, new int[]{3,2}};
        System.out.println(Arrays.toString(restoreArray(array)));
    }
}
