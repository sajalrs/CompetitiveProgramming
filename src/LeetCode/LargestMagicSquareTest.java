package LeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static  org.junit.jupiter.api.Assertions.assertEquals;
public class LargestMagicSquareTest {

    private LargestMagicSquare largestMagicSquare;
    @BeforeEach
    public void setup(){
        largestMagicSquare = new LargestMagicSquare();
    }

    @Test
    @DisplayName("Test 1")
    public void test1(){

        int[][] array = new int[][]{new int[]{5,1,3,1},new int[]{9,3,3,1},new int[]{1,3,3,8}};
        largestMagicSquare.largestMagicSquare(array);

    }

}
