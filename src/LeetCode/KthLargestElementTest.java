package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthLargestElementTest {

    KthLargestElement kthLargestElement;

    @BeforeEach
    public void setup(){
        kthLargestElement = new KthLargestElement();
    }

    @Test
    @DisplayName("Input: nums = [3,2,1,5,6,4], k = 2\n" +
            "Output: 5")
    public void test1(){
        assertEquals(5, kthLargestElement.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }


    @Test
    @DisplayName("Input: nums = [3,2,3,1,2,4,5,5,6], k = 4\n" +
            "Output: 4")
    public void test2(){
        assertEquals(4, kthLargestElement.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
