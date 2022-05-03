package CrackingTheCodingInterview;

import java.util.*;
import java.util.Queue;

public class PaintFill {
    public void paintFill(int[][] screen, int[] point, int newColor) {
        int prevColor = screen[point[0]][point[1]];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);
        Map<Integer, Set<Integer>> visited = new HashMap<>();

        for (int col = 0; col < screen.length; ) {
            visited.put(col, new HashSet<>());
        }

        int[][] deltas = new int[][]{new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}};

        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            int x = curPoint[0];
            int y = curPoint[1];
            screen[y][x] = newColor;
            for (int[] delta : deltas) {
                int newX = x + delta[0];
                int newY = y + delta[1];
                if (newY >= 0 && newY < screen.length && newX >= 0 && newX < screen[0].length) {
                    if (!visited.get(newY).contains(newX) && screen[y][x] == prevColor) {
                        visited.get(newY).add(newX);
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
