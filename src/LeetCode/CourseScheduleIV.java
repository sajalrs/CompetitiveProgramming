package LeetCode;

import java.util.*;

public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> isPrereq = new ArrayList<>(queries.length);
        if(prerequisites.length == 0) {
            for(int i = 0; i< queries.length; i++){
                isPrereq.add(false);
            }
            return isPrereq;
        }

        boolean[][] adjacencyMatrix = new boolean[numCourses][numCourses];

        for(int[] prerequisite: prerequisites){
            adjacencyMatrix[prerequisite[0]][prerequisite[1]] = true;
        }

       for(int k=0; k<numCourses; k++){
           for(int i=0; i<numCourses; i++){
               for(int j=0; j<numCourses; j++){
                    adjacencyMatrix[i][j] = adjacencyMatrix[i][j] || (adjacencyMatrix[i][k] && adjacencyMatrix[k][j]);
               }
           }
       }

      for(int[] query: queries){
          isPrereq.add(adjacencyMatrix[query[0]][query[1]]);
      }
      return isPrereq;
    }



}
