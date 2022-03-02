package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneAwayTest {
    OneAway oneAway;

    @BeforeEach
    public void setup(){
        oneAway = new OneAway();
    }

    @Test
    @DisplayName("pale, ple -> true")
    public void test1(){
        assertEquals(true, oneAway.oneAway("pale", "ple"));
    }

    @Test
    @DisplayName("pales, pale -> true")
    public void test2(){
        assertEquals(true, oneAway.oneAway("pales","pale"));
    }

    @Test
    @DisplayName("pale, bale -> true")
    public void test3(){
        assertEquals(true, oneAway.oneAway("pale","bale"));
    }

    @Test
    @DisplayName("pale, bake -> false")
    public void test4(){
        assertEquals(false, oneAway.oneAway("pale","bake"));
    }
}
