package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorIITest {

    private BasicCalculatorII basicCalculatorII;

    @BeforeEach
    public void setup(){
        basicCalculatorII = new BasicCalculatorII();
    }

    @Test
    @DisplayName("Input: s = \"3+2*2\"\n" +
            "Output: 7")
    public void test1(){
        assertEquals(7,basicCalculatorII.calculate("3+2*2"));
    }

    @Test
    @DisplayName("Input: s = \"3/2\"\n" +
            "Output: 1")
    public void test2(){
        assertEquals(1,basicCalculatorII.calculate("3/2"));
    }

    @Test
    @DisplayName("Input: s = \"3+5/2\"\n" +
            "Output: 5")
    public void test3(){
        assertEquals(5,basicCalculatorII.calculate("3+5/2"));
    }
}
