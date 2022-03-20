package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountHillValleyTest {
    CountHillValley countHillValley;
    @BeforeEach
    public void setup(){
        countHillValley = new CountHillValley();
    }

    @Test
    public void test1(){
        assertEquals(3, countHillValley.countHillValley(new int[]{2,4,1,1,6,5}));
    }

    @Test
    public void test2(){
        assertEquals(0, countHillValley.countHillValley(new int[]{6,6,5,5,4,1}));
    }

    @Test
    public void test3(){
        assertEquals(0, countHillValley.countHillValley(new int[]{6,1}));
    }
}
