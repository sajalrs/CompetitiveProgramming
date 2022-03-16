package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindKDistantIndicesTest {
    FindKDistantIndices findKDistantIndices;
    @BeforeEach
    public void setup(){
        findKDistantIndices = new FindKDistantIndices();
    }

    @Test
    public void test1(){
        Integer[] arr = findKDistantIndices.findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1).toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
       assertArrayEquals(new Integer[]{1,2,3,4,5,6}, arr);
    }

    @Test
    public void test2(){
        Integer[] arr = findKDistantIndices.findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2).toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(new Integer[]{0,1,2,3,4}, arr);
    }
}
