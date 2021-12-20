package LeetCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDescentPeriodsTest {

    GetDescentPeriods getDescentPeriods;

    @BeforeEach
    public void setup(){
        getDescentPeriods = new GetDescentPeriods();
    }

    @Test
    @DisplayName("Input: prices = [3,2,1,4]\n" +
            "Output: 7")
    public void test1() {
        assertEquals(7, getDescentPeriods.getDescentPeriods(new int[]{3,2,1,4}));
    }

    @Test
    @DisplayName("Input: prices = [8,6,7,7]\n" +
            "Output: 4")
    public void test2() {
        assertEquals(4, getDescentPeriods.getDescentPeriods(new int[]{8,6,7,7}));
    }

    @Test
    @DisplayName("Input: prices = [1]\n" +
            "Output: 1")
    public void test3() {
        assertEquals(1, getDescentPeriods.getDescentPeriods(new int[]{1}));
    }
}
