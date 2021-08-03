package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class NumberOfBurgersTest {

    private NumberOfBurgers numberOfBurgers;

    @BeforeEach
    public void setup(){
        numberOfBurgers = new NumberOfBurgers();
    }

    @Test
    @DisplayName("Input: tomatoSlices = 16, cheeseSlices = 7\n" +
            "Output: [1,6]")
    public void test1(){
        List<Integer> list = numberOfBurgers.numOfBurgers(16,7);
        assertArrayEquals(new Integer[]{1,6}, list.toArray());
    }

    @Test
    @DisplayName("Input: tomatoSlices = 17, cheeseSlices = 4\n" +
            "Output: []")
    public void test2(){
        List<Integer> list = numberOfBurgers.numOfBurgers(17,4);
        assertArrayEquals(new Integer[]{}, list.toArray());
    }

    @Test
    @DisplayName("Input: tomatoSlices = 4, cheeseSlices = 17\n" +
            "Output: []")
    public void test3(){
        List<Integer> list = numberOfBurgers.numOfBurgers(4,17);
        assertArrayEquals(new Integer[]{}, list.toArray());
    }

}
