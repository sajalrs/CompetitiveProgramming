package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountSpecialQuadrupletsTest {

    CountSpecialQuadruplets countSpecialQuadruplets;

    @BeforeEach
    public void setup(){
        countSpecialQuadruplets = new CountSpecialQuadruplets();
    }

    @Test
    @DisplayName("Input: nums = [1,2,3,6]\n" +
            "Output: 1\n" +
            "Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) because 1 + 2 + 3 == 6.")
    public void test1(){
        assertEquals(1,countSpecialQuadruplets.countQuadruplets(new int[]{1,2,3,6}));
    }


    @Test
    @DisplayName("Input: nums = [3,3,6,4,5]\n" +
            "Output: 0\n" +
            "Explanation: There are no such quadruplets in [3,3,6,4,5].")
    public void test2(){
        assertEquals(0,countSpecialQuadruplets.countQuadruplets(new int[]{3,3,6,4,5}));
    }

    @Test
    @DisplayName("Input: nums = [1,1,1,3,5]\n" +
            "Output: 4\n" +
            "Explanation: The 4 quadruplets that satisfy the requirement are:\n" +
            "- (0, 1, 2, 3): 1 + 1 + 1 == 3\n" +
            "- (0, 1, 3, 4): 1 + 1 + 3 == 5\n" +
            "- (0, 2, 3, 4): 1 + 1 + 3 == 5\n" +
            "- (1, 2, 3, 4): 1 + 1 + 3 == 5")
    public void test3(){
        assertEquals(4,countSpecialQuadruplets.countQuadruplets(new int[]{1,1,1,3,5}));
    }
}
