package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimalKSumTest {
    MinimalKSum minimalKSum;
    @BeforeEach
    public void setup(){
        minimalKSum = new MinimalKSum();
    }

    @Test
    @DisplayName("Input: nums = [1,4,25,10,25], k = 2\n" +
            "Output: 5\n" +
            "Explanation: The two unique positive integers that do not appear in nums which we append are 2 and 3.\n" +
            "The resulting sum of nums is 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70, which is the minimum.\n" +
            "The sum of the two integers appended is 2 + 3 = 5, so we return 5.")
    public void test1(){
        assertEquals(5, minimalKSum.minimalKSum(new int[]{1,4,25,10,25}, 2));
    }

    @Test
    @DisplayName("Input: nums = [5,6], k = 6\n" +
            "Output: 25\n" +
            "Explanation: The six unique positive integers that do not appear in nums which we append are 1, 2, 3, 4, 7, and 8.\n" +
            "The resulting sum of nums is 5 + 6 + 1 + 2 + 3 + 4 + 7 + 8 = 36, which is the minimum. \n" +
            "The sum of the six integers appended is 1 + 2 + 3 + 4 + 7 + 8 = 25, so we return 25.")
    public void test2(){
        assertEquals(25, minimalKSum.minimalKSum(new int[]{5,6}, 6));
    }

}
