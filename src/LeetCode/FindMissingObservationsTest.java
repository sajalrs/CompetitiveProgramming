package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMissingObservationsTest {

    private FindMissingObservations findMissingObservations;

    @BeforeEach
    public void setup() {
        findMissingObservations = new FindMissingObservations();
    }

    @Test
    @DisplayName("Input: rolls = [1,5,6], mean = 3, n = 4")
    public void test1() {
        assertArrayEquals(new int[]{3,2,2,2}, findMissingObservations.missingRolls(new int[]{1,5,6},3,4));
    }

    @Test
    @DisplayName("Input: rolls = [3,5,3], mean = 5, n = 3\n")
    public void test2() {
        assertArrayEquals(new int[]{}, findMissingObservations.missingRolls(new int[]{3,5,3},5,3));
    }

    @Test
    @DisplayName("Input: rolls = [6,3,4,3,5,3], mean = 1, n =6\n")
    public void test3() {
        assertArrayEquals(new int[]{}, findMissingObservations.missingRolls(new int[]{6,3,4,3,5,3},1,6));
    }

    @Test
    @DisplayName("Input: rolls = [6,1,5,2], mean = 4, n =4\n")
    public void test4() {
        int[] array = findMissingObservations.missingRolls(new int[]{6,1,5,2},4,4);
        System.out.println(Arrays.toString(array));
        assertArrayEquals(new int[]{5,5,4,4}, array);
    }
}
