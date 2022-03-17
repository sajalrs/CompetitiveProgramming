package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueViaStackTest {
    QueueViaStack<Integer> queueViaStack;

    @BeforeEach
    public void setup(){
        queueViaStack = new QueueViaStack();
    }

    @Test
    public void test1(){
        Integer[] num = new Integer[]{1,2,3,4,5};
        for(int number : num){
            queueViaStack.add(number);
        }

        List<Integer> test = new ArrayList<>();
        while (!queueViaStack.isEmpty()){
            test.add(queueViaStack.remove());
        }

        assertArrayEquals(num, test.toArray());
    }

    @Test
    public void test2(){
        queueViaStack.add(0);
        queueViaStack.add(2);
        assertEquals(0, queueViaStack.remove());
        queueViaStack.add(5);
        assertEquals(2, queueViaStack.peek());
        assertEquals(2, queueViaStack.remove());
        queueViaStack.add(3);
        queueViaStack.add(4);
        assertEquals(5,queueViaStack.remove());
        assertEquals(3,queueViaStack.remove());
        assertEquals(4,queueViaStack.remove());
    }


}
