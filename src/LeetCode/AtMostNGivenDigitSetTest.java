package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtMostNGivenDigitSetTest {

    AtMostNGivenDigitSet atMostNGivenDigitSet;

    @BeforeEach
    public void setup() {
        atMostNGivenDigitSet = new AtMostNGivenDigitSet();
    }

    @Test
    @DisplayName("Input: digits = [\"1\",\"3\",\"5\",\"7\"], n = 100\n" +
            "Output: 20")
    public void test1() {
        assertEquals(20, atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
    }


    @Test
    @DisplayName("Input: digits = [\"1\",\"4\",\"9\"], n = 1000000000\n" +
            "Output: 29523")
    public void test2() {
        assertEquals(29523, atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000));
    }

    @Test
    @DisplayName("Input: digits = [\"7\"], n = 8\n" +
            "Output: 1\n")
    public void test3() {
        assertEquals(1, atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"7"}, 8));
    }

    @Test
    @DisplayName("Input: digits = [\"1\",\"2\",\"3\",\"4\",\"7\",\"8\",\"9\"], n = [\"1\",\"2\",\"3\",\"4\",\"7\",\"8\",\"9\"]\n" +
            "32901345\n" +
            "Output: 1\n")
    public void test4() {
        assertEquals(1, atMostNGivenDigitSet.atMostNGivenDigitSet(new String[]{"1","2","3","4","7","8","9"},
        32901345));
    }
}
