package Blind75;

import java.util.*;

public class CourseSchedule {
    public List<Integer> courseOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            set.add(i);
            adjacencyList.put(i, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            int before = prerequisite[1];
            int after = prerequisite[0];
            set.remove(after);
            adjacencyList.get(before).add(after);
        }

        Stack<Integer> stack = new Stack<>();
        for(int num: set){
            stack.add(num);
        }
        set = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()){
            int curCourse = stack.pop();
            order.add(curCourse);
            set.add(curCourse);
            for(int course: adjacencyList.get(curCourse)){
                boolean cannotBeTaken = false;
                for(int i=0; i<numCourses && !cannotBeTaken; i++){
                    if(i==curCourse || i==course) continue;
                    if(adjacencyList.get(i).contains(course) && !set.contains(i)){
                        cannotBeTaken = true;
                    }
                }
                if(!cannotBeTaken && !set.contains(course)){
                    stack.push(course);
                }
            }
        }
        return order;
    }

    public static void main(String[] args){
        CourseSchedule courseSchedule = new CourseSchedule();
//        for(int i: courseSchedule.courseOrder(2, new int[][]{new int[]{1,0}})){
//            System.out.println(i);
//        }
//
//        for(int i: courseSchedule.courseOrder(2, new int[][]{new int[]{1,0},new int[]{0,1}})){
//            System.out.println(i);
//        }

        for(int i: courseSchedule.courseOrder(5, new int[][]{new int[]{1,4},new int[]{2,4},new int[]{3,1},new int[]{3,2}})){
            System.out.println(i);
        }
    }
}
