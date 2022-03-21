package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaximumBobPoints {
    int max = 0;
    int[] maxBobArrows = new int[12];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        maximumBobPointsHelper(numArrows, aliceArrows, 0, 11, new int[12]);
        return maxBobArrows;
    }

    void maximumBobPointsHelper(int numArrows, int[] aliceArrows, int curScore, int round, int[] bobArrows) {
        if (numArrows <= 0 || round < 0) {
            if (numArrows > 0) {
                bobArrows[0] += numArrows;
            }

            if (curScore > max) {
                max = curScore;
                for(int i=0; i<bobArrows.length; i++){
                    maxBobArrows[i] = bobArrows[i];
                }
            }
            return;
        }

        if (numArrows >= aliceArrows[round] + 1) {
            bobArrows[round] = aliceArrows[round] + 1;
            maximumBobPointsHelper(numArrows - (aliceArrows[round] + 1), aliceArrows, curScore + round, round - 1, bobArrows);
            bobArrows[round] = 0;
        }
        maximumBobPointsHelper(numArrows, aliceArrows, curScore, round - 1, bobArrows);
        bobArrows[round] = 0;
    }
}
