package LeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ImageSmootherTest {

    ImageSmoother imageSmoother;

    @BeforeEach
    public void setup() {
        imageSmoother = new ImageSmoother();
    }

    @Test
    @DisplayName("Input: img = [[1,1,1],[1,0,1],[1,1,1]]\n" +
            "Output: [[0,0,0],[0,0,0],[0,0,0]]\n")
    public void test1() {

        int[][] img = new int[][]{new int[]{1, 1, 1}, new int[]{1, 0, 1}, new int[]{1, 1, 1}};
        int[][] imgSupposed = new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}};
        int[][] smoothedImage = imageSmoother.imageSmoother(img);

        for (int i = 0; i < img.length; i++) {
            assertArrayEquals(smoothedImage[i], imgSupposed[i]);
        }
    }

    @Test
    @DisplayName("Input: img = [[100,200,100],[200,50,200],[100,200,100]]\n" +
            "Output: [[137,141,137],[141,138,141],[137,141,137]]")
    public void test2() {

        int[][] img = new int[][]{new int[]{100, 200, 100}, new int[]{200, 50, 200}, new int[]{100, 200, 100}};
        int[][] imgSupposed = new int[][]{new int[]{137, 141, 137}, new int[]{141, 138, 141}, new int[]{137, 141, 137}};
        int[][] smoothedImage = imageSmoother.imageSmoother(img);

        for (int i = 0; i < img.length; i++) {
            assertArrayEquals(smoothedImage[i], imgSupposed[i]);
        }
    }

}
