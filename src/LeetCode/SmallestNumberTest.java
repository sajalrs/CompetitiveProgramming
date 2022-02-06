package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmallestNumberTest {

    private SmallestNumber smallestNumber;
    @BeforeEach
    public void setup(){
        smallestNumber = new SmallestNumber();
    }

    @Test
    @DisplayName("Input: num = 310\n" +
            "Output: 103\n" +
            "Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310. \n" +
            "The arrangement with the smallest value that does not contain any leading zeros is 103.")
    public void test1(){
        assertEquals(103l, smallestNumber.smallestNumber(310l));
    }

    @Test
    @DisplayName("Input: num = -7605\n" +
            "Output: -7650\n" +
            "Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.\n" +
            "The arrangement with the smallest value that does not contain any leading zeros is -7650.")
    public void test2(){
        assertEquals(-7650l, smallestNumber.smallestNumber(-7605l));
    }

    @Test
    @DisplayName("Input: num = 0\n" +
            "Output: 0\n")
    public void test3(){
        assertEquals(0l, smallestNumber.smallestNumber(0l));
    }

    @Test
    @DisplayName("Input: num = 5\n" +
            "Output: 5\n")
    public void test4(){
        assertEquals(5l, smallestNumber.smallestNumber(5l));
    }

    @Test
    @DisplayName("Input: num = 50\n" +
            "Output: 50\n")
    public void test5(){
        assertEquals(50l, smallestNumber.smallestNumber(50l));
    }
}
