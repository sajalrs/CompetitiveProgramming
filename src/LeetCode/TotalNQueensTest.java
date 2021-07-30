package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalNQueensTest {

    TotalNQueens totalNQueens;

    @BeforeEach
    public void setup(){
        totalNQueens = new TotalNQueens();
    }

    @Test
    @DisplayName("n=4, Output = 2")
    public void test1(){
        assertEquals(2, totalNQueens.totalNQueens(4));
    }

    @Test
    @DisplayName("n=1, Output = 1")
    public void test2(){
        assertEquals(1, totalNQueens.totalNQueens(1));
    }

}
