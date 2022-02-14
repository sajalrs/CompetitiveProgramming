package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumOperationsTest {
    private MinimumOperations minimumOperations;
    @BeforeEach
    public void setup(){
        minimumOperations = new MinimumOperations();
    }

    @DisplayName("Input: nums = [3,1,3,2,4,3]\n" +
            "Output: 3\n" +
            "Explanation:\n" +
            "One way to make the array alternating is by converting it to [3,1,3,1,3,1].\n" +
            "The number of operations required in this case is 3.\n" +
            "It can be proven that it is not possible to make the array alternating in less than 3 operations. ")
    @Test
    public void test1(){
        assertEquals(3, minimumOperations.minimumOperations(new int[]{3,1,3,2,4,3}));
    }

    @DisplayName("Input: nums = [1,2,2,2,2]\n" +
            "Output: 2\n" +
            "Explanation:\n" +
            "One way to make the array alternating is by converting it to [1,2,1,2,1].\n" +
            "The number of operations required in this case is 2.\n" +
            "Note that the array cannot be converted to [2,2,2,2,2] because in this case nums[0] == nums[1] which violates the conditions of an alternating array. ")
    @Test
    public void test2(){
        assertEquals(2, minimumOperations.minimumOperations(new int[]{1,2,2,2,2}));
    }

    @DisplayName("Input: nums = [48,61,73,15,83,4,5,22,61,80,4,92,9,91,89,94,28,13,57,94,55,2,24,23,26,31,66,18,62,4,99,60,35,10,61]\n" +
            "Output: 31 ")
    @Test
    public void test3(){
        assertEquals(31, minimumOperations.minimumOperations(new int[]{48,61,73,15,83,4,5,22,61,80,4,92,9,91,89,94,28,13,57,94,55,2,24,23,26,31,66,18,62,4,99,60,35,10,61}));
    }

    @DisplayName("Input: nums = [3,3,3,4,3,3,3]\n" +
            "Output: 2 ")
    @Test
    public void test4(){
        assertEquals(2, minimumOperations.minimumOperations(new int[]{3,3,3,4,3,3,3}));
    }
}
