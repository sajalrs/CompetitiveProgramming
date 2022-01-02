package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExecuteInstructions {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        Map<Integer, Map<Integer, Map<Integer, Integer>>> prevExecutions = new HashMap<>();
        int[] toReturn = new int[s.length()];
        for(int i = 0; i< s.length(); i++){
            int curX = startPos[0];
            int curY = startPos[1];

            int initX = curX;
            int initY = curY;

            int charIndex = i;
            int numMoves = 0;

            if (!prevExecutions.containsKey(initX) || !prevExecutions.get(initX).containsKey(initY) || !prevExecutions.get(initX).get(initY).containsKey(charIndex)) {
                for (char curChar : s.substring(i).toCharArray()) {

                    switch (curChar) {
                        case 'L':
                            curY--;
                            break;

                        case 'R':
                            curY++;
                            break;

                        case 'D':
                            curX++;
                            break;

                        case 'U':
                            curX--;
                            break;
                    }

                    if (curX >=0 && curX < n && curY>=0 && curY < n) {
                        numMoves++;
                    } else {
                        break;
                    }
                }
            }
            if (!prevExecutions.containsKey(initX)) {
                prevExecutions.put(initX, new HashMap<>());
            }

            if (!prevExecutions.get(initX).containsKey(initY)) {
                prevExecutions.get(initX).put(initY, new HashMap<>());
            }

            prevExecutions.get(initX).get(initY).put(charIndex, numMoves);
            toReturn[i] =  prevExecutions.get(initX).get(initY).get(charIndex);
        }

        System.out.println(Arrays.toString(toReturn));
        return toReturn;
    }
}
