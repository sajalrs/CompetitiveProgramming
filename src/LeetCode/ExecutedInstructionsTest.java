package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExecutedInstructionsTest {
   ExecuteInstructions executeInstructions;

    @BeforeEach
    public void setup() {
        executeInstructions = new ExecuteInstructions();
    }

    @Test
    @DisplayName("Input: n = 3, startPos = [0,1], s = \"RRDDLU\"\n" +
            "Output: [1,5,4,3,1,0]\n" +
            "Explanation: Starting from startPos and beginning execution from the ith instruction:\n" +
            "- 0th: \"RRDDLU\". Only one instruction \"R\" can be executed before it moves off the grid.\n" +
            "- 1st:  \"RDDLU\". All five instructions can be executed while it stays in the grid and ends at (1, 1).\n" +
            "- 2nd:   \"DDLU\". All four instructions can be executed while it stays in the grid and ends at (1, 0).\n" +
            "- 3rd:    \"DLU\". All three instructions can be executed while it stays in the grid and ends at (0, 0).\n" +
            "- 4th:     \"LU\". Only one instruction \"L\" can be executed before it moves off the grid.\n" +
            "- 5th:      \"U\". If moving up, it would move off the grid.")
    public void test1() {
        assertArrayEquals(new int[]{1,5,4,3,1,0}, executeInstructions.executeInstructions(3, new int[]{0,1}, "RRDDLU"));
    }

    @Test
    @DisplayName("Input: n = 2, startPos = [1,1], s = \"LURD\"\n" +
            "Output: [4,1,0,0]\n" +
            "Explanation:\n" +
            "- 0th: \"LURD\".\n" +
            "- 1st:  \"URD\".\n" +
            "- 2nd:   \"RD\".\n" +
            "- 3rd:    \"D\".")
    public void test2() {
        assertArrayEquals(new int[]{4,1,0,0}, executeInstructions.executeInstructions(2, new int[]{1,1}, "LURD"));
    }

    @Test
    @DisplayName("Input: n = 1, startPos = [0,0], s = \"LRUD\"\n" +
            "Output: [0,0,0,0]\n" +
            "Explanation: No matter which instruction the robot begins execution from, it would move off the grid.")
    public void test3() {
        assertArrayEquals(new int[]{0,0,0,0}, executeInstructions.executeInstructions(1, new int[]{0,0}, "LRUD"));
    }
}
