package LeetCode;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double min = - Double.MAX_VALUE;

        while(!stack.isEmpty() || root !=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val <= min) return false;
            min = root.val;
            root = root.right;
        }

        return true;

    }

    public static boolean isValidBST(TreeNode root){
        return isValidBSTRecursive(root);
    }


    public static boolean isValidBSTRecursive(TreeNode root){
        return isValidBSTRecursive(root, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTRecursive(TreeNode root, int min) {
        if(root.left != null){
            return isValidBSTRecursive(root.left, root.val);
        }

        if(root.val >= min){
            return false;
        }

        if(root.right != null){
            return isValidBSTRecursive(root.right, root.val);
        }

        return true;
    }




    public static void main(String[] args){
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        System.out.println(isValidBST(root1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        System.out.println(isValidBST(root2));


        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);

        System.out.println(isValidBST(root3));


        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(1);

        System.out.println(isValidBST(root4));
    }


}
