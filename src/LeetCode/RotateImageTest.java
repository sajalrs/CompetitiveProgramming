package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateImageTest {

    private RotateImage rotateImage;

    @BeforeEach
    public void setup() {
        rotateImage = new RotateImage();
    }

    @Test
    @DisplayName("2x2")
    public void test0() {
        int[][] matrix = new int[][]{new int[]{1, 2}, new int[]{4, 5}};
        int[][] matrix2 = new int[][]{new int[]{4, 1}, new int[]{5, 2}};

        rotateImage.rotate(matrix);

        assertArrayEquals(matrix[0], matrix2[0]);
        assertArrayEquals(matrix[1], matrix2[1]);
    }

    @Test
    @DisplayName("3x3")
    public void test1() {
        int[][] matrix = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{7, 8, 9}};
        int[][] matrix2 = new int[][]{new int[]{7, 4, 1}, new int[]{8, 5, 2}, new int[]{9, 6, 3}};

        rotateImage.rotate(matrix);

        assertArrayEquals(matrix[0], matrix2[0]);
        assertArrayEquals(matrix[1], matrix2[1]);
        assertArrayEquals(matrix[2], matrix2[2]);


    }


    @Test
    @DisplayName("4x4")
    public void test2() {
        int[][] matrix = new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}};
        int[][] matrix2 = new int[][]{new int[]{15, 13, 2, 5}, new int[]{14, 3, 4, 1}, new int[]{12, 6, 8, 9}, new int[]{16, 7, 10, 11}};

        rotateImage.rotate(matrix);

        assertArrayEquals(matrix[0], matrix2[0]);
        assertArrayEquals(matrix[1], matrix2[1]);
        assertArrayEquals(matrix[2], matrix2[2]);
        assertArrayEquals(matrix[3], matrix2[3]);

    }


}
