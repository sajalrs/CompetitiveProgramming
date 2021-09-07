package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarrayTest {

    MaximumProductSubarray maximumProductSubarray;

    @BeforeEach
    public void setup(){
        maximumProductSubarray = new MaximumProductSubarray();
    }

    @Test
    @DisplayName("Input: nums = [2,3,-2,4]\n" +
            "Output: 6\n" +
            "Explanation: [2,3] has the largest product 6.")
    public void test1(){
        assertEquals(6, maximumProductSubarray.maxProduct(new int[]{2,3,-2,4}));
    }


    @Test
    @DisplayName("Input: nums = [-2,0,-1]\n" +
            "Output: 0\n" +
            "Explanation: The result cannot be 2, because [-2,-1] is not a subarray.")
    public void test2(){
        assertEquals(0, maximumProductSubarray.maxProduct(new int[]{-2,0,-1}));
    }
}
