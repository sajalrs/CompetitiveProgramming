package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeRequiredToBuyTest {
    private TimeRequiredToBuy timeRequiredToBuy;

    @BeforeEach
    public void setup(){
        timeRequiredToBuy = new TimeRequiredToBuy();
    }

    @Test
    @DisplayName("Input: tickets = [2,3,2], k = 2\n" +
            " Output: 6")
    public void test1(){
        assertEquals(timeRequiredToBuy.timeRequiredToBuy(new int[]{2,3,2},2),6);
    }

    @Test
    @DisplayName("Input: tickets = [5,1,1,1], k = 0\n" +
            " Output: 8")
    public void test2(){
        assertEquals(timeRequiredToBuy.timeRequiredToBuy(new int[]{5,1,1,1},0),8);
    }
}
