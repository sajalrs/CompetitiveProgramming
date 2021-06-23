package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTest {

    FirstMissingPositive firstMissingPositive;

    @BeforeEach
    public void setup() {
        firstMissingPositive = new FirstMissingPositive();
    }

    @Test
    @DisplayName("[1,2,0]")
    public void test1() {
        int[] arr = new int[]{1, 2, 0};

        assertEquals(3, firstMissingPositive.firstMissingPositive(arr));
    }


    @Test
    @DisplayName("[3,4,-1,1]")
    public void test2() {
        int[] arr = new int[]{3, 4, -1, 1};

        assertEquals(2, firstMissingPositive.firstMissingPositive(arr));
    }

    @Test
    @DisplayName("[7,8,9,11,12]")
    public void test3() {
        int[] arr = new int[]{7, 8, 9, 11, 12};

        assertEquals(1, firstMissingPositive.firstMissingPositive(arr));
    }

}
