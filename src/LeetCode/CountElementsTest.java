package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountElementsTest {

    CountElements countElements;
    @BeforeEach
    public void setup(){
        countElements = new CountElements();
    }

    @Test
    @DisplayName("Input: nums = [11,7,2,15]\n" +
            "Output: 2\n" +
            "Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.\n" +
            "Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.\n" +
            "In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.")
    public void test1(){
        assertEquals(2, countElements.countElements(new int[]{11,7,2,15}));
    }


    @Test
    @DisplayName("Input: nums = [-3,3,3,90]\n" +
            "Output: 2\n" +
            "Explanation: The element 3 has the element -3 strictly smaller than it and the element 90 strictly greater than it.\n" +
            "Since there are two elements with the value 3, in total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.")
    public void test2(){
        assertEquals(2, countElements.countElements(new int[]{-3,3,3,90}));
    }

    @Test
    @DisplayName("Input: nums = [-100000,-99999,-99999]\n" +
            "Output: 2")
    public void test3(){
        assertEquals(0, countElements.countElements(new int[]{-100000,-99999,-99999}));
    }
}
