package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RearrangeArrayTest {

    RearrangeArray rearrangeArray;
    @BeforeEach
    public void setup(){
        rearrangeArray = new RearrangeArray();
    }

    @Test
    @DisplayName("Input: nums = [3,1,-2,-5,2,-4]\n" +
            "Output: [3,-2,1,-5,2,-4]\n" +
            "Explanation:\n" +
            "The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].\n" +
            "The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].\n" +
            "Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.")
    public void test1(){
        assertArrayEquals(new int[]{3,-2,1,-5,2,-4}, rearrangeArray.rearrangeArray(new int[]{3,1,-2,-5,2,-4}));
    }

    @Test
    @DisplayName("Input: nums = [-1,1]\n" +
            "Output: [1,-1]\n" +
            "Explanation:\n" +
            "1 is the only positive integer and -1 the only negative integer in nums.\n" +
            "So nums is rearranged to [1,-1].")
    public void test2(){
        assertArrayEquals(new int[]{1,-1}, rearrangeArray.rearrangeArray(new int[]{-1,1}));
    }

}
