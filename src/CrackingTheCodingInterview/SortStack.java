package CrackingTheCodingInterview;
import java.util.Stack;
public class SortStack{

    //Similar to tower of hanoi
    public void sortStack(Stack<Integer> stack){
        Stack<Integer> helperStack = new Stack<>();
        while (!stack.isEmpty()){
            helperStack.push(stack.pop());
        }

        while (!helperStack.isEmpty()){
            if(stack.isEmpty()){
                stack.push(helperStack.pop());
            }
            if(helperStack.peek() > stack.peek()){
                int num = helperStack.pop();
                while (!stack.isEmpty()){
                    helperStack.push(stack.pop());
                }
                stack.push(num);
                while (!helperStack.isEmpty() && helperStack.peek() < stack.peek()){
                    stack.push(helperStack.pop());
                }
            }else {
                stack.push(helperStack.pop());
            }
        }

    }
}
