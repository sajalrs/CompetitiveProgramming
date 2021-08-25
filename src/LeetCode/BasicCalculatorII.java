package LeetCode;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                total = (total * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(total);
                } else if (sign == '-') {
                    stack.push(-total);
                } else if (sign == '*') {
                    stack.push(total * stack.pop());
                } else if (sign == '/') {
                    stack.push(stack.pop() / total);
                }

                total = 0;
                sign = currentChar;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
