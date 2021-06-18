package LeetCode;

import java.util.Stack;

public class MinimumOperationsToFlip {
    int pos = 0;
    private class TreeNode{
        public TreeNode leftNode;
        public TreeNode rightNode;
        public char val;
        public TreeNode(char val){
            this.val = val;
        }

    }

    public int minOperationsToFlip(String expression) {

        Stack<TreeNode> root = new Stack<>();
        readExpression(root, expression);
        int res[] = dfs(root.pop());
        return Math.max(res[0], res[1]);
    }

    int[] dfs(TreeNode node){
        if(node.leftNode == null && node.rightNode == null){
            int val = node.val - '0';
            return new int[]{val^0, val^1};
        }

        int[] left = dfs(node.leftNode);
        int[] right = dfs(node.rightNode);

        if(node.val == '&'){
          int minCostForZero = Math.min(left[0], right[0]);
          int minCostForOne = Math.min(left[1], right[1]);
          return  new int[]{minCostForZero, minCostForOne};
        } else if(node.val == '|'){
            int minCostForZero = Math.min(left[0] + right[0], 1 + Math.min(left[0], right[0]));
            int minCostForOne = Math.min(left[1],right[1]);
            return new int[]{minCostForZero, minCostForOne};
        } else {
            throw new IllegalStateException();
        }

    }



    public void readExpression(Stack<TreeNode> stack, String expression){
        if(pos == expression.length())
            return;

        char curChar = expression.charAt(pos++);
        if(curChar == '0' || curChar == '1'){
            TreeNode node = new TreeNode(curChar);

            if(stack.isEmpty()){
                stack.add(node);
            }else {
                stack.peek().rightNode = node;
            }
        } else if(curChar == '('){
            Stack<TreeNode> tempRoot = new Stack<>();
            readExpression(tempRoot, expression);

            if(stack.isEmpty()){
                stack.add(tempRoot.pop());
            }else {
                stack.pop().rightNode = tempRoot.pop();
            }
        }else if(curChar == ')'){
            return;
        } else {
          TreeNode node = new TreeNode(curChar);
          node.leftNode = stack.pop();
          stack.push(node);

          readExpression(stack, expression);
        }



    }

}
