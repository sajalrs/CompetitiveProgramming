package LeetCode;

import java.util.*;

public class FindCenter {


    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> graph = new HashMap<>();
        for(int i =0; i<edges.length; i++){
            if(graph.containsKey(edges[i][0])){
                graph.put(edges[i][0], graph.get(edges[i][0])+1);
            } else {
                graph.put(edges[i][0], 1);
            }
            if(graph.containsKey(edges[i][1])){
                graph.put(edges[i][1], graph.get(edges[i][1])+1);
            } else {
                graph.put(edges[i][1], 1);
            }
        }

        int n = graph.keySet().size();

        for(int key: graph.keySet()){
            if(graph.get(key) == n-1) return key;
        }

        return -1;

    }



    public static void main(String[] args){
        int[][] edges = new int[][]{new int[]{1,2},new int[]{2,3},new int[]{4,2}};
        System.out.println(findCenter(edges));
    }

}
