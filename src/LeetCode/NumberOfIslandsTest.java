package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsTest {

    private NumberOfIslands numberOfIslands;

    @BeforeEach
    public void setup() {
        numberOfIslands = new NumberOfIslands();
    }

    @Test
    @DisplayName("Input: grid = [\n" +
            "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
            "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
            "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
            "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
            "]\n" +
            "Output: 1")
    public void test1() {
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        
        assertEquals(1,numberOfIslands.numIslands(grid));
    }

    @Test
    @DisplayName("Input: grid = [\n" +
            "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
            "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
            "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
            "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
            "]\n" +
            "Output: 3")
    public void test2() {
        char[][] grid = new char[][]{
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'}
        };

        assertEquals(3,numberOfIslands.numIslands(grid));
    }

}
