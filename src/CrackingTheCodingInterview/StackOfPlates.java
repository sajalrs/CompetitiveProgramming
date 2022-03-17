package CrackingTheCodingInterview;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class StackOfPlates {
    private class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private class Stack<T> implements CrackingTheCodingInterview.Stack<T> {
        private StackNode<T> top;
        private int size = 0;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            size--;
            return item;
        }

        public void push(T item) {
            StackNode<T> t = new StackNode<T>(item);
            t.next = top;
            top = t;
            size++;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    private class StackOfStack {
        int size;
        final int THRESHOLD = 10;
        Stack<Stack<Integer>> stackOfStacks;

        StackOfStack() {
            size = 0;
            stackOfStacks = new Stack<>();
        }

        public int pop() {
            if (size == 0) {
                if (isEmpty()) throw new EmptyStackException();
                stackOfStacks.pop();
                size = 10;
            }
            size--;
            return stackOfStacks.peek().pop();
        }

        public void push(int item) {
            if (size == THRESHOLD) {
                stackOfStacks.push(new Stack<>());
                size = 0;
            }
            stackOfStacks.peek().push(item);
            size++;
        }

        public int peek() {
            return stackOfStacks.peek().peek();
        }

        public boolean isEmpty() {
            return stackOfStacks.isEmpty();
        }
    }

    private class StackOfStackLists {
        int size;
        final int THRESHOLD = 10;
        List<Stack<Integer>> stackOfStacks;

        StackOfStackLists() {
            size = 0;
            stackOfStacks = new LinkedList<>();
        }

        private Stack<Integer> getLastStack() {
            return stackOfStacks.get(stackOfStacks.size() - 1);
        }

        public int pop() {
            if (size == 0) {
                if (isEmpty()) throw new EmptyStackException();
                stackOfStacks.remove(stackOfStacks.get(stackOfStacks.size() - 1));
                size = 10;
            }
            size--;
            return getLastStack().pop();
        }

        public int popAt(int index) {
            if (index == stackOfStacks.size() - 1)
                return pop();
            int num = stackOfStacks.get(index).pop();
            rollover(index);
            size--;
            if (size == 0) {
                stackOfStacks.remove(stackOfStacks.size() - 1);
                size = THRESHOLD;
            }
            return num;
        }

        public void rollover(int index) {
            for (int i = index + 1; i < stackOfStacks.size(); i++) {
                Stack newStack = new Stack();
                Stack curStack = stackOfStacks.get(i);
                Stack prevStack = stackOfStacks.get(i - 1);

                while (!curStack.isEmpty()) {
                    newStack.push(curStack.pop());
                }

                while (prevStack.size != THRESHOLD && newStack.isEmpty()) {
                    prevStack.push(newStack.pop());
                }

                while (!newStack.isEmpty()) {
                    curStack.push(newStack.pop());
                }
            }

        }

        public void push(int item) {
            if (size == THRESHOLD) {
                stackOfStacks.add(new Stack<>());
                size = 0;
            }
            getLastStack().push(item);
            size++;
        }

        public int peek() {
            return getLastStack().peek();
        }

        public boolean isEmpty() {
            return stackOfStacks.isEmpty();
        }
    }


}
