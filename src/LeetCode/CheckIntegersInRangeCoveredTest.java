package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckIntegersInRangeCoveredTest {

    CheckIntegersInRangeCovered checkIntegersInRangeCovered;

    @BeforeEach
    public void setup(){
        checkIntegersInRangeCovered = new CheckIntegersInRangeCovered();
    }

    @Test
    @DisplayName("Test 1")
    public void test1(){
        int[][] ranges = new int[][]{new int[]{1,2},new int[]{3,4},new int[]{5,6}};
        int left = 2;
        int right = 5;
        assertEquals(true,checkIntegersInRangeCovered.isCovered(ranges, left, right));
    }

    @Test
    @DisplayName("Test 2")
    public void test2(){
        int[][] ranges = new int[][]{new int[]{1,10},new int[]{10,20}};
        int left = 21;
        int right = 21;
        assertEquals(false,checkIntegersInRangeCovered.isCovered(ranges, left, right));
    }

}
