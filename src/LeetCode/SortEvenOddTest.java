package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortEvenOddTest {
    private SortEvenOdd sortEvenOdd;

    @BeforeEach
    public void setup(){
        sortEvenOdd = new SortEvenOdd();
    }

    @Test
    @DisplayName("Input: nums = [4,1,2,3]\n" +
            "Output: [2,3,4,1]\n" +
            "Explanation: \n" +
            "First, we sort the values present at odd indices (1 and 3) in non-increasing order.\n" +
            "So, nums changes from [4,1,2,3] to [4,3,2,1].\n" +
            "Next, we sort the values present at even indices (0 and 2) in non-decreasing order.\n" +
            "So, nums changes from [4,1,2,3] to [2,3,4,1].\n" +
            "Thus, the array formed after rearranging the values is [2,3,4,1].")
    public void test1(){
        assertArrayEquals(new int[]{2,3,4,1},sortEvenOdd.sortEvenOdd(new int[]{4,1,2,3}));
    }

    @Test
    @DisplayName("Input: nums = [2,1]\n" +
            "Output: [2,1]\n" +
            "Explanation: \n" +
            "Since there is exactly one odd index and one even index, no rearrangement of values takes place.\n" +
            "The resultant array formed is [2,1], which is the same as the initial array. ")
    public void test2(){
        assertArrayEquals(new int[]{2,1},sortEvenOdd.sortEvenOdd(new int[]{2,1}));
    }

}

