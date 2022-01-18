package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMovesTest {
    MinMoves minMoves;

    @BeforeEach
    public void setup(){
        minMoves = new MinMoves();
    }

    @Test
    @DisplayName("Input: target = 5, maxDoubles = 0\n" +
            "Output: 4\n" +
            "Explanation: Keep incrementing by 1 until you reach target.")
    public void test1(){
        assertEquals(4, minMoves.minMoves(5,0));
    }

    @Test
    @DisplayName("Input: target = 19, maxDoubles = 2\n" +
            "Output: 7\n" +
            "Explanation: Initially, x = 1\n" +
            "Increment 3 times so x = 4\n" +
            "Double once so x = 8\n" +
            "Increment once so x = 9\n" +
            "Double again so x = 18\n" +
            "Increment once so x = 19")
    public void test2(){
        assertEquals(7, minMoves.minMoves(19,2));
    }

    @Test
    @DisplayName("Input: target = 10, maxDoubles = 4\n" +
            "Output: 4\n" +
            "Explanation: Initially, x = 1\n" +
            "Increment once so x = 2\n" +
            "Double once so x = 4\n" +
            "Increment once so x = 5\n" +
            "Double again so x = 10")
    public void test3(){
        assertEquals(4, minMoves.minMoves(10,4));
    }
}
