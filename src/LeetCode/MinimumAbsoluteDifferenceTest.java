package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinimumAbsoluteDifferenceTest {

    private MinimumAbsoluteDifference minimumAbsoluteDifference;

    @BeforeEach
    public void setup() {
        minimumAbsoluteDifference = new MinimumAbsoluteDifference();
    }

    @Test
    @DisplayName("Input: arr = [4,2,1,3]\n" +
            "Output: [[1,2],[2,3],[3,4]]")
    public void test1() {
        List<List<Integer>> ans = minimumAbsoluteDifference.minimumAbsDifference(new int[]{4, 2, 1, 3});
        Integer[][] checkAgainst = new Integer[][]{new Integer[]{1,2},new Integer[]{2,3},new Integer[]{3,4}};

        for(int i=0; i< ans.size(); i++){
            List<Integer> answer = ans.get(i);
            assertArrayEquals(checkAgainst[i], answer.toArray());
        }

    }

    @Test
    @DisplayName("Input: arr = [1,3,6,10,15]\n" +
            "Output: [[1,3]]")
    public void test2() {
        List<List<Integer>> ans = minimumAbsoluteDifference.minimumAbsDifference(new int[]{1,3,6,10,15});
        Integer[][] checkAgainst = new Integer[][]{new Integer[]{1,3}};

        for(int i=0; i< ans.size(); i++){
            List<Integer> answer = ans.get(i);
            assertArrayEquals(checkAgainst[i], answer.toArray());
        }

    }

    @Test
    @DisplayName("Input: arr = [3,8,-10,23,19,-4,-14,27]\n" +
            "Output: [[-14,-10],[19,23],[23,27]]")
    public void test3() {
        List<List<Integer>> ans = minimumAbsoluteDifference.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27});
        Integer[][] checkAgainst = new Integer[][]{new Integer[]{-14,-10},new Integer[]{19,23}, new Integer[]{23,27}};

        for(int i=0; i< ans.size(); i++){
            List<Integer> answer = ans.get(i);
            assertArrayEquals(checkAgainst[i], answer.toArray());
        }

    }
}
