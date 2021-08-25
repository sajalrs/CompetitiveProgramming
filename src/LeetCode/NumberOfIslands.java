package LeetCode;

import java.util.Stack;

public class NumberOfIslands  {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int[][] delta = new int[][]{new int[]{0,1}, new int[]{1,0}, new int[]{0,-1}, new int[]{-1, 0}};
        Stack<int[]> queue = new Stack<>();
        int count = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == '0') continue;
                queue.push(new int[]{i,j});


                while (!queue.isEmpty()){
                    int arr[] = queue.pop();
                    grid[arr[0]][arr[1]] = '0';

                    for(int k=0; k<delta.length;k++) {

                        int x = arr[0] + delta[k][0];
                        int y = arr[1] + delta[k][1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length && grid[x][y] == '1') {
                            queue.push(new int[]{x, y});
                        }
                    }
                }

              count++;
            }
        }
        return count;
    }

}
