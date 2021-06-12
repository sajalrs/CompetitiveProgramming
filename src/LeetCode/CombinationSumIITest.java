package LeetCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIITest {

    private CombinationSumII combinationSum;
    @BeforeEach
    public void setUp(){
        combinationSum = new CombinationSumII();
    }

    @Test
    @DisplayName("Test 1")
    public void test1(){
        int[] arr = new int[]{1,2,2,2,5};

        List<Integer> sum1 = new ArrayList<Integer>();
        sum1.add(1);
        sum1.add(2);
        sum1.add(2);

        List<Integer> sum2 = new ArrayList<Integer>();
        sum2.add(5);

        List<List<Integer>> comSum = new ArrayList<>();
        comSum.add(sum1);
        comSum.add(sum2);


        assertEquals(comSum, combinationSum.combinationSum2(arr, 5));

    }

}
