package DataStructuresAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortRevisionTest {

    QuickSortRevision quickSortRevision;

    @BeforeEach
    public void setUp(){
        quickSortRevision = new QuickSortRevision();
    }

    @Test
    @DisplayName("[5,2,1,4,3]")
    public void test1(){

        assertArrayEquals(new int[]{1,2,3,4,5},quickSortRevision.QuickSort(new int[]{5,2,1,4,3}));
    }

    @Test
    @DisplayName("Empty Array")
    public void test2(){

        assertArrayEquals(new int[]{},quickSortRevision.QuickSort(new int[]{}));
    }

    @Test
    @DisplayName("Descending")
    public void test3(){

        assertArrayEquals(new int[]{1,2,3,4,5},quickSortRevision.QuickSort(new int[]{5,4,3,2,1}));
    }

}
