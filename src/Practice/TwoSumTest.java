package Practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {
    TwoSum twoSum;

    @BeforeEach
    public void setup() {
        twoSum = new TwoSum();
    }

    @Test
    public void test1() {
        int[] actual = twoSum.twoSumTrivial(new int[]{2, 7, 11, 15}, 9);
        Arrays.sort(actual);
        int[] expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void test2() {
        int[] actual = twoSum.twoSumTrivial(new int[]{3, 2, 4}, 6);
        Arrays.sort(actual);
        int[] expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] actual = twoSum.twoSumTrivial(new int[]{3, 3}, 6);
        Arrays.sort(actual);
        int[] expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] actual = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        Arrays.sort(actual);
        int[] expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void test5() {
        int[] actual = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        Arrays.sort(actual);
        int[] expected = new int[]{1, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] actual = twoSum.twoSum(new int[]{3, 3}, 6);
        Arrays.sort(actual);
        int[] expected = new int[]{0, 1};
        assertArrayEquals(expected, actual);
    }
}
