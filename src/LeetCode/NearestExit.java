package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NearestExit {

    public int nearestExit(char[][] maze, int[] entrance) {
       return dfs(maze, entrance);
    }

    public int dfs(char[][] maze, int[] entrance) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int[][] delta = new int[][]{new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0,-1}};
        int steps = 1;

        while (!queue.isEmpty()){
            int queueLength = queue.size();
            for(int i=0; i<queueLength; i++){

                int[] curSpot = queue.poll();
                for(int j=0; j< delta.length; j++){
                    int x = curSpot[0] + delta[j][0];
                    int y = curSpot[1] + delta[j][1];

                    if(x<maze.length && x>=0 && y<maze[0].length && y>=0 && maze[x][y] != '+'){
                        if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
                            return steps;
                        }else {
                            maze[x][y] = '+';

                            queue.add(new int[]{x,y});
                        }
                    }
                }
            }
            steps++;
        }

        return -1;



    }

}
