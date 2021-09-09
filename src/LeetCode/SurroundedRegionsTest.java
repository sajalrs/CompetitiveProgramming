package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SurroundedRegionsTest {

    SurroundedRegions surroundedRegions;

    @BeforeEach
    public void setup() {
        surroundedRegions = new SurroundedRegions();
    }

    @Test
    @DisplayName("Input: board = [[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]\n" +
            "Output: [[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]")
    public void test1() {

        char[][] board = new char[][]{new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'O', 'O', 'X'}, new char[]{'X', 'X', 'O', 'X'}, new char[]{'X', 'O', 'X', 'X'}};
        char[][] expectedBoard = new char[][]{new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'X', 'X', 'X'}, new char[]{'X', 'O', 'X', 'X'}};
        surroundedRegions.solve(board);

        for(int i =0; i<board.length; i++){
            assertArrayEquals(expectedBoard[i],board[i]);
        }

    }

    @Test
    @DisplayName("Input: board = [[\"X\"]]\n" +
            "Output: [[\"X\"]]")
    public void test2() {

        char[][] board = new char[][]{new char[]{'X'}};
        char[][] expectedBoard = new char[][]{new char[]{'X'}};
        surroundedRegions.solve(board);

        for(int i =0; i<board.length; i++){
            assertArrayEquals(expectedBoard[i],board[i]);
        }

    }

    @Test
    @DisplayName("Input: board = [[[\"O\",\"O\",\"O\",\"O\",\"X\",\"X\"],[\"O\",\"O\",\"O\",\"O\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"O\",\"O\"]]\n" +
            "Output: [[\"O\",\"O\",\"O\",\"O\",\"X\",\"X\"],[\"O\",\"O\",\"O\",\"O\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"O\"],[\"O\",\"X\",\"O\",\"O\",\"O\",\"O\"]]")
    public void test3() {

        char[][] board = new char[][]{new char[]{'O','O','O','O','X','X'},new char[]{'O','O','O','O','O','O'},new char[]{'O','X','O','X','O','O'},new char[]{'O','X','O','O','X','O'},new char[]{'O','X','O','X','O','O'},new char[]{'O','X','O','O','O','O'}};
        char[][] expectedBoard = new char[][]{new char[]{'O','O','O','O','X','X'},new char[]{'O','O','O','O','O','O'},new char[]{'O','X','O','X','O','O'},new char[]{'O','X','O','O','X','O'},new char[]{'O','X','O','X','O','O'},new char[]{'O','X','O','O','O','O'}};
        surroundedRegions.solve(board);

        for(int i =0; i<board.length; i++){
            assertArrayEquals(expectedBoard[i],board[i]);
        }

    }

}
