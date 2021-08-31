package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KthSmallestElementTest {

    KthSmallestElement kthSmallestElement;

    @BeforeEach
    public void setup(){
        kthSmallestElement = new KthSmallestElement();
    }

    @Test
    @DisplayName("Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8\n" +
            "Output: 13\n" +
            "Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13\n")
    public void test1(){
        int[][] arr = new int[][]{new int[]{1,5,9},new int[]{10,11,13},new int[]{12,13,15}};
        assertEquals(13,kthSmallestElement.kthSmallest(arr,8));
    }

    @Test
    @DisplayName("Input: matrix = [[-5]], k = 1\n" +
            "Output: -5")
    public void test2(){
        int[][] arr = new int[][]{new int[]{-5}};
        assertEquals(-5,kthSmallestElement.kthSmallest(arr,1));
    }
}
