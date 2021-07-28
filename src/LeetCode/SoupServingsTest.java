package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SoupServingsTest {

    private SoupServings soupServings;

    @BeforeEach
    public void setup(){
        soupServings = new SoupServings();
    }

    @Test
    @DisplayName("n = 50, 0.62500")
    public void test1(){
        assertEquals(0.62500,soupServings.soupServings(50));
    }

    @Test
    @DisplayName("n = 100, 0.71875")
    public void test2(){
        assertEquals(0.71875,soupServings.soupServings(100));
    }

    @Test
    @DisplayName("n = 1, 0.62500")
    public void test3(){
        assertEquals(0.62500,soupServings.soupServings(1));
    }
}
