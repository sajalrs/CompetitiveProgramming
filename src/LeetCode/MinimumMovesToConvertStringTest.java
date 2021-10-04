package LeetCode;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumMovesToConvertStringTest {


    private MinimumMovesToConvertString minimumMovesToConvertString;

    @BeforeEach
    public void setup() {
        minimumMovesToConvertString = new MinimumMovesToConvertString();
    }

    @Test
    @DisplayName("Input: s = \"XXX\"\n" +
            "Output: 1\n" +
            "Explanation: XXX -> OOO\n" +
            "We select all the 3 characters and convert them in one move.")
    public void test1() {
       assertEquals(1,minimumMovesToConvertString.minimumMoves("XXX"));
    }

    @Test
    @DisplayName("Input: s = \"XXOX\"\n" +
            "Output: 2\n" +
            "Explanation: XXOX -> OOOX -> OOOO\n" +
            "We select the first 3 characters in the first move, and convert them to 'O'.\n" +
            "Then we select the last 3 characters and convert them so that the final string contains all 'O's.")
    public void test2() {
        assertEquals(2,minimumMovesToConvertString.minimumMoves("XXOX"));
    }

    @Test
    @DisplayName("Input: s = \"OOOO\"\n" +
            "Output: 0\n" +
            "Explanation: There are no 'X's in s to convert.")
    public void test3() {
        assertEquals(0,minimumMovesToConvertString.minimumMoves("OOOO"));
    }

    @Test
    @DisplayName("Input: s = \"\"OXOX\"\"\n" +
            "Output: 1\n")
    public void test4() {
        assertEquals(1,minimumMovesToConvertString.minimumMoves("OXOX"));
    }

    @Test
    @DisplayName("Input: s = \"\"XXXX\"\"\n" +
            "Output: 2\n")
    public void test5() {
        assertEquals(2,minimumMovesToConvertString.minimumMoves("XXXX"));
    }

    @Test
    @DisplayName("Input: s = \"\"XXXXX\"\"\n" +
            "Output: 2\n")
    public void test6() {
        assertEquals(2,minimumMovesToConvertString.minimumMoves("XXXXX"));
    };

    @Test
    @DisplayName("Input: s = \"\"OXOOXO\"\"\n" +
            "Output: 2\n")
    public void test7() {
        assertEquals(2,minimumMovesToConvertString.minimumMoves("OXOOXO"));
    };


}
