package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CellsInRangeTest {
    CellsInRange cellsInRange;
    @BeforeEach
    public void setup(){
        cellsInRange = new CellsInRange();
    }

    @Test
    @DisplayName("Input: s = \"A1:F1\"\n" +
            "Output: [\"A1\",\"B1\",\"C1\",\"D1\",\"E1\",\"F1\"]\n" +
            "Explanation:\n" +
            "The above diagram shows the cells which should be present in the list.\n" +
            "The red arrow denotes the order in which the cells should be presented.")
    public void test1(){
        List<String> arr = cellsInRange.cellsInRange("A1:F1");
        assertArrayEquals(new String[]{"A1","B1","C1","D1","E1","F1"},arr.toArray());
    }

    @Test
    @DisplayName("Input: s = \"K1:L2\"\n" +
            "Output: [\"K1\",\"K2\",\"L1\",\"L2\"]\n" +
            "Explanation:\n" +
            "The above diagram shows the cells which should be present in the list.\n" +
            "The red arrows denote the order in which the cells should be presented.")
    public void test2(){
        List<String> arr = cellsInRange.cellsInRange("K1:L2");
        assertArrayEquals(new String[]{"K1","K2","L1","L2"},arr.toArray());
    }
}
