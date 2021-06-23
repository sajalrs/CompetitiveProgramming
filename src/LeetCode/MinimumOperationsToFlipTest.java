package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumOperationsToFlipTest
{

    MinimumOperationsToFlip minimumOperationsToFlip;

    @BeforeEach
    public void setup(){
        minimumOperationsToFlip = new MinimumOperationsToFlip();
    }

    @Test
    @DisplayName("Test 1")
    public void test1(){
        assertEquals(minimumOperationsToFlip.minOperationsToFlip("1&(0|1)"), 1);
    }

    @Test
    @DisplayName("Test 2")
    public void test2(){
        assertEquals( 3,minimumOperationsToFlip.minOperationsToFlip("(0&0)&(0&0&0)"));
    }


}
