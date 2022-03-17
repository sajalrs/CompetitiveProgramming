package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortStackTest {
    SortStack sortStack;
    @BeforeEach
    public void setup(){
        sortStack = new SortStack();
    }

    @Test
    public void test1(){
        Stack<Integer> stack = new Stack<>();
        int[] num = new int[]{1,4,2,3,5};
        for(int i=0; i<5; i++){
            stack.push(num[i]);
        }

        sortStack.sortStack(stack);
        List<Integer> sorted = new ArrayList<>();

        while (!stack.isEmpty()){
            sorted.add(stack.pop());
        }

        assertArrayEquals(new Integer[]{1,2,3,4,5}, sorted.toArray());
    }
}
