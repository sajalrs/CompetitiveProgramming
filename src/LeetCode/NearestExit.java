package LeetCode;

public class NearestExit {

    int minSteps = -1;

    public int nearestExit(char[][] maze, int[] entrance) {

        maze[entrance[0]][entrance[1]] = '+';
        backtrack(maze, new int[]{entrance[0] + 1, entrance[1]}, 1);
        backtrack(maze, new int[]{entrance[0] - 1, entrance[1]}, 1);
        backtrack(maze, new int[]{entrance[0], entrance[1] + 1}, 1);
        backtrack(maze, new int[]{entrance[0], entrance[1] - 1}, 1);
        return minSteps;
    }

    public void backtrack(char[][] maze, int[] curSpot, int steps) {
        int x = curSpot[0];
        int y = curSpot[1];

        if (x > maze.length - 1 || x < 0 || y > maze[0].length - 1 || y < 0) {
            return;
        }

        if (maze[x][y] == '+') {
            return;
        }

        if(minSteps != -1 && minSteps <= steps){
            return;
        }


        if (x == 0 || x == maze.length - 1 || y == 0 || y == maze[0].length - 1) {
            if (minSteps == -1) {
                minSteps = steps;
            } else {
                minSteps = Math.min(minSteps, steps);
            }
        }

        maze[x][y] = '+';

        backtrack(maze, new int[]{x + 1, y}, steps + 1);
        backtrack(maze, new int[]{x - 1, y}, steps + 1);
        backtrack(maze, new int[]{x, y + 1}, steps + 1);
        backtrack(maze, new int[]{x, y - 1}, steps + 1);

        maze[x][y] = '.';


    }

}
