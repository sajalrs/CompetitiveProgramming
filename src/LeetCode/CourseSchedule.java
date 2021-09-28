package LeetCode;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<numCourses;i++){
            graph.put(i,new LinkedList<>());
        }

        for(int[] prerequisite: prerequisites){
                graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        for(int i=0; i< numCourses;i++){
            if(!(dfs(graph, i, new HashSet<>()))) return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> graph, int curCourse, Set<Integer> visit){
        if(visit.contains(curCourse)) return false;
        if(graph.get(curCourse).size() == 0) return true;

        visit.add(curCourse);
        for(int preq: graph.get(curCourse)){
            if(!dfs(graph, preq, visit)) return false;
        }

        visit.remove(curCourse);
        graph.put(curCourse, new LinkedList<>());
        return true;
    }
}
