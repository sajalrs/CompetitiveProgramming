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

        assertEquals(2,largestMagicSquare.largestMagicSquare(array));
    }

    @Test
    @DisplayName("Test 2")
    public void test2(){

        int[][] array = new int[][]{new int[]{7,1,4,5,6},new int[]{2,5,1,6,4},new int[]{1,5,4,3,2},new int[]{1,2,7,3,4}};

        assertEquals(3,largestMagicSquare.largestMagicSquare(array));
    }

    @Test
    @DisplayName("Test 3")
    public void test3(){

        int[][] array = new int[][]{new int[]{8,1,6},new int[]{3,5,7},new int[]{4,9,2},new int[]{7, 10,9}};

        assertEquals(3,largestMagicSquare.largestMagicSquare(array));
    }

}
