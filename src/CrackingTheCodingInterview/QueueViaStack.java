package CrackingTheCodingInterview;

import java.util.Stack;

public class QueueViaStack<T> implements Queue<T> {

    Stack<T> stack1 = new Stack();
    Stack<T> stack2 = new Stack();

    @Override
    public void add(T item) {
        stack1.add(item);
    }

    @Override
    public T remove() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }

        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }

    @Override
    public T peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }

        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
