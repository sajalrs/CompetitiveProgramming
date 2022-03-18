package CrackingTheCodingInterview;

import java.util.Queue;
import java.util.*;

public class RouteBetweenNodes {

    public boolean RouteBetweenNodes(Map<Integer, List<Integer>> graph, int node1, int node2) {
       return bfs(graph, node1, node2);
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, int start, int dest){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> alreadyVisited = new HashSet<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int curNode = queue.poll();
            if(!alreadyVisited.contains(curNode)){
                for(int num: graph.get(curNode)){
                    queue.add(num);
                }

                if(curNode == dest){
                    return true;
                }
            }
            alreadyVisited.add(curNode);
        }

        return false;
    }


}
