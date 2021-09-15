package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SquaresOfSortedArrayTest {
    private SquaresOfSortedArray squaresOfSortedArray;
    @BeforeEach
    public void setup(){
        squaresOfSortedArray = new SquaresOfSortedArray();
    }

    @Test
    @DisplayName("Input: nums = [-4,-1,0,3,10]\n" +
            "Output: [0,1,9,16,100]\n" +
            "Explanation: After squaring, the array becomes [16,1,0,9,100].\n" +
            "After sorting, it becomes [0,1,9,16,100].")
    public void test1(){
        assertArrayEquals(new int[]{0,1,9,16,100},squaresOfSortedArray.sortedSquares(new int[]{-4,-1,0,3,10}));
    }

    @Test
    @DisplayName("Input: nums = [-7,-3,2,3,11]\n" +
            "Output: [4,9,9,49,121]")
    public void test2(){
        assertArrayEquals(new int[]{4,9,9,49,121},squaresOfSortedArray.sortedSquares(new int[]{-7,-3,2,3,11}));
    }

    @Test
    @DisplayName("Input: nums = [-1,2,2]\n" +
            "Output: [1,4,4]")
    public void test3(){
        assertArrayEquals(new int[]{1,4,4},squaresOfSortedArray.sortedSquares(new int[]{-1,2,2}));
    }

}
