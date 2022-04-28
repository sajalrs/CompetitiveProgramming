package CrackingTheCodingInterview;

import java.util.*;
import java.util.Stack;

public class RobotInAGrid {
    public List<int[]> findPath(char[][] maze) {
        return findPathDFSIterative(maze);
    }


    public List<int[]> findPathDFSIterative(char[][] maze) {
        int[] bottomRight = new int[]{maze.length - 1, maze[0].length - 1};
        Stack<List<int[]>> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        stack.push(list);
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        for (int i = 0; i < maze.length; i++) {
            visited.put(i, new HashSet<>());
        }

        int[][] deltas = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        while (!stack.isEmpty()) {
            List<int[]> curPath = stack.pop();
            int[] curPos = curPath.get(curPath.size() - 1);
            if (curPos[0] == bottomRight[0] && curPos[1] == bottomRight[1]) return curPath;
            for (int[] delta : deltas) {
                int x = curPos[0] + delta[0];
                int y = curPos[1] + delta[1];
                if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !visited.get(x).contains(y) && maze[x][y] != 'X') {
                    visited.get(x).add(y);
                    List<int[]> path = new ArrayList<>(curPath);
                    path.add(new int[]{x, y});
                    stack.push(path);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RobotInAGrid robotInAGrid = new RobotInAGrid();
        char[][] maze1 = new char[][]{
                new char[]{'.', 'X'},
                new char[]{'.', '.'}};
        for (int[] path : robotInAGrid.findPath(maze1)) {
            System.out.println(Arrays.toString(path));
        }

        System.out.println();

        char[][] maze2 = new char[][]{
                new char[]{'.', 'X', '.'},
                new char[]{'.', '.', '.'},
                new char[]{'.', 'X', '.'}};
        for (int[] path : robotInAGrid.findPath(maze2)) {
            System.out.println(Arrays.toString(path));
        }
        System.out.println();

        char[][] maze3 = new char[][]{
                new char[]{'.', '.', '.','.'},
                new char[]{'X', 'X', 'X','.'},
                new char[]{'.', 'X', '.','.'}};
        for (int[] path : robotInAGrid.findPath(maze3)) {
            System.out.println(Arrays.toString(path));
        }

    }

}
