package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BuildOrderTest {
    BuildOrder buildOrder;
    @BeforeEach
    public void setup(){
        buildOrder = new BuildOrder();
    }

    @Test
    public void test1(){
        char[] path =  buildOrder.buildOrder(new char[]{'a','b','c','d','e','f'}, new char[][]{new char[]{'a','d'},new char[]{'f','b'},new char[]{'b','d'},new char[]{'f','a'},new char[]{'d','c'}});
        System.out.println(Arrays.toString(path));
        assertArrayEquals(new char[]{'e','f','a','b','d','c'},path);
    }
}
