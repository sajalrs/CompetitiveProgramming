package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestArithSeqLengthTest {

    private LongestArithSeqLength longestArithSeqLength;

    @BeforeEach
    public void setup(){
        longestArithSeqLength = new LongestArithSeqLength();
    }

    @Test
    @DisplayName("Input: nums = [3,6,9,12]\n" +
            "Output: 4")
    public void test1(){
        assertEquals(4, longestArithSeqLength.longestArithSeqLength(new int[]{3,6,9,12}));
    }

    @Test
    @DisplayName("Input: nums = [9,4,7,2,10]\n" +
            "Output: 3")
    public void test2(){
        assertEquals(3, longestArithSeqLength.longestArithSeqLength(new int[]{9,4,7,2,10}));
    }

    @Test
    @DisplayName("Input: nums = [20,1,15,3,10,5,8]\n" +
            "Output: 4")
    public void test3(){
        assertEquals(4, longestArithSeqLength.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }



}
