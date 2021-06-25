package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TrappingRainWaterTest {

    TrappingRainWater trappingRainWater;

    @BeforeEach
    public void setup(){
        trappingRainWater = new TrappingRainWater();
    }

    @Test
    @DisplayName("[0,1,0,2,1,0,1,3,2,1,2,1]")
    public void test1(){
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        assertEquals(6, trappingRainWater.trap(arr));
    }


    @Test
    @DisplayName("[4,2,0,3,2,5]")
    public void test2(){
        int[] arr = new int[]{4,2,0,3,2,5};
        assertEquals( 9, trappingRainWater.trap(arr));
    }



}
