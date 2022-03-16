package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackMinTest {

    StackMin stackMin;
    @BeforeEach
    public void setup(){
        stackMin = new StackMin();
    }

    @Test
    public void test1(){
        int[] num = new int[]{4,3,1,2};

        stackMin.push(num[0]);
        assertEquals(4,stackMin.peek());
        assertEquals(4,stackMin.getMin());

        stackMin.push(num[3]);
        assertEquals(2,stackMin.getMin());

        stackMin.push(num[1]);
        assertEquals(2,stackMin.getMin());

        stackMin.push(num[2]);
        assertEquals(1,stackMin.getMin());

        assertEquals(1, stackMin.pop());
        assertEquals(2,stackMin.getMin());
    }


}
