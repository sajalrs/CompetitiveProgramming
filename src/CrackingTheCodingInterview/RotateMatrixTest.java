package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateMatrixTest {
    RotateMatrix rotateMatrix;
    @BeforeEach
    public void setup(){
        rotateMatrix = new RotateMatrix();
    }

    @Test
    @DisplayName("Input: \n" +
            "[1,2,3] \n" +
            "[4,5,6] \n" +
            "[7,8,9] \n" +
            "Output: \n" +
            "[7,4,1] \n" +
            "[8,5,2] \n" +
            "[9,6,3] \n")
    public void test1(){
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };

        rotateMatrix.rotateMatrix(matrix);

        assertArrayEquals(new int[]{7,4,1}, matrix[0]);
        assertArrayEquals(new int[]{8,5,2}, matrix[1]);
        assertArrayEquals(new int[]{9,6,3}, matrix[2]);
    }

    @Test
    @DisplayName("Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n" +
            "Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]")
    public void test2(){
        int[][] matrix = new int[][]{
                new int[]{5,1,9,11},new int[]{2,4,8,10},new int[]{13,3,6,7},new int[]{15,14,12,16}
        };
        rotateMatrix.rotateMatrix(matrix);
        assertArrayEquals(new int[]{15,13,2,5}, matrix[0]);
        assertArrayEquals(new int[]{14,3,4,1}, matrix[1]);
        assertArrayEquals(new int[]{12,6,8,9}, matrix[2]);
        assertArrayEquals(new int[]{16,7,10,11}, matrix[3]);
    }

}
