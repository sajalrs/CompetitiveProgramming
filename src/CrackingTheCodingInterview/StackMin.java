package CrackingTheCodingInterview;

import java.util.EmptyStackException;

public class StackMin {
    private StackNode top;
    private int globalMin = Integer.MAX_VALUE;

    public int pop() {
        if (top == null) throw new EmptyStackException();
        globalMin = top.localMin;
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item) {
        StackNode cur = new StackNode(item, globalMin);
        globalMin = Math.min(item, globalMin);
        cur.next = top;
        top = cur;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public int getMin() {
        if (top == null) throw new EmptyStackException();
        return globalMin;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode {
        private int data;
        private StackNode next;
        public int localMin;

        StackNode(int data, int min) {
            this.data = data;
            this.localMin = min;
        }
    }
}
