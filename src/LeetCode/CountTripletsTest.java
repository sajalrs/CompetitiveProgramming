package LeetCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CountTripletsTest {

   CountTriplets countTriplets;

    @BeforeEach
    public void setup(){
        countTriplets= new CountTriplets();
    }

    @Test
    @DisplayName(" n = 5")
    public void test1(){
      assertEquals(2, countTriplets.countTriples(5));
    }

    @Test
    @DisplayName("n=10")
    public void test2(){

        assertEquals(4, countTriplets.countTriples(10));

    }
}
