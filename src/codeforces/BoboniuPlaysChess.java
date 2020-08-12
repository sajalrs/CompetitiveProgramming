package codeforces;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BoboniuPlaysChess {

    static boolean[][] visited;
    static boolean visitedAll = false;
    static Queue<String> moveStack = new LinkedList<String>();
    public static void main(String[] args){
        Scanner scr = new Scanner(System.in);
        String[] entries = scr.nextLine().split(" ");
        int n = Integer.valueOf(entries[0]);
        int m = Integer.valueOf(entries[1]);
        int x0 = Integer.valueOf(entries[2]);
        int y0 = Integer.valueOf(entries[3]);

        visited = new boolean[n+1][m+1];
        visited[x0][y0] = true;
        moveAround(x0,y0,1);

        while(!(moveStack.isEmpty())){
            System.out.println(moveStack.remove());
        }
    }

    static void moveAround(int x, int y, int totalVisited){
        visited[x][y] = true;
        moveStack.add(String.format("%d %d",x,y));
        if(totalVisited == (visited.length-1) * (visited[0].length-1)){
            visitedAll = true;
            return;
        }

        for(int i=1; i< visited.length; i++){
            if(!(visited[i][y])){
                visited[i][y] = true;
                moveAround(i,y, totalVisited+1);
            }
        }

        for(int j=1; j< visited[0].length; j++){
            if(!(visited[x][j])){
                visited[x][j] = true;
                moveAround(x,j, totalVisited+1);
            }
        }

        if(!visitedAll){
            moveStack.remove();
        }

        return;

    }

}
