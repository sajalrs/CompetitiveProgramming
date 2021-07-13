package LeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NearestExitTest {

    public NearestExit nearestExit;

    @BeforeEach
    public void setup() {
        nearestExit = new NearestExit();
    }

    @Test
    @DisplayName("maze = [[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]], entrance = [1,2]")
    public void test1() {
        char[][] maze = new char[][]{new char[]{'+', '+', '.', '+'}, new char[]{'.', '.', '.', '+'}, new char[]{'+', '+', '+', '.'}};
        int[] entrance = new int[]{1, 2};

        assertEquals(1, nearestExit.nearestExit(maze, entrance));
    }

    @Test
    @DisplayName("maze = [[\".\",\"+\"]], entrance = [0,0]")
    public void test2() {
        char[][] maze = new char[][]{new char[]{'.', '+'}};
        int[] entrance = new int[]{0, 0};
        assertEquals(-1, nearestExit.nearestExit(maze, entrance));
    }

    @Test
    @DisplayName("maze = [[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]], entrance = [1,0]")
    public void test3() {
        char[][] maze = new char[][]{new char[]{'+', '+', '+'}, new char[]{'.', '.', '.'}, new char[]{'+', '+', '+'}};
        int[] entrance = new int[]{1, 0};

        assertEquals(2, nearestExit.nearestExit(maze, entrance));
    }


}
