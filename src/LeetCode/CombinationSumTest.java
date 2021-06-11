package LeetCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumTest {

    private CombinationSum combinationSum;
    @BeforeEach
    public void setUp(){
        combinationSum = new CombinationSum();
    }

    @Test
    @DisplayName("Test 1")
    public void test1(){
        int[] arr = new int[]{2,3,6,7};

        List<Integer> sum1 = new ArrayList<Integer>();
        sum1.add(2);
        sum1.add(2);
        sum1.add(3);

        List<Integer> sum2 = new ArrayList<Integer>();
        sum2.add(7);

        List<List<Integer>> comSum = new ArrayList<>();
        comSum.add(sum2);
        comSum.add(sum1);

        assertEquals(comSum, combinationSum.combinationSum(arr, 7));

    }

}
