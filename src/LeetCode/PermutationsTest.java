package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PermutationsTest {
    private Permutations permutations;

    @BeforeEach
    public void setup(){
        permutations = new Permutations();
    }

    @Test
    @DisplayName("Input: nums = [1,2,3]\n" +
            "Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]")
    public void test1(){
        int[] input = new int[]{1,2,3};
        Integer[][] output = new Integer[][]{new Integer[]{1,2,3},new Integer[]{1,3,2},new Integer[]{2,1,3}
                ,new Integer[]{2,3,1},new Integer[]{3,1,2},new Integer[]{3,2,1}};

        List<List<Integer>> list = permutations.permute(input);
        for(Integer i=0; i<output.length; i++){
            assertArrayEquals(list.get(i).toArray(),output[i]);
        }
    }

    @Test
    @DisplayName("Input: nums = [0,1]\n" +
            "Output: [[0,1],[1,0]]")
    public void test2(){
        int[] input = new int[]{0,1};
        Integer[][] output = new Integer[][]{new Integer[]{0,1},new Integer[]{1,0}};

        List<List<Integer>> list = permutations.permute(input);
        for(Integer i=0; i<output.length; i++){
            assertArrayEquals(list.get(i).toArray(),output[i]);
        }
    }

    @Test
    @DisplayName("Input: nums = [1]\n" +
            "Output: [[1]]")
    public void test3(){
        int[] input = new int[]{1};
        Integer[][] output = new Integer[][]{new Integer[]{1}};

        List<List<Integer>> list = permutations.permute(input);
        for(Integer i=0; i<output.length; i++){
            assertArrayEquals(list.get(i).toArray(),output[i]);
        }
    }

}
