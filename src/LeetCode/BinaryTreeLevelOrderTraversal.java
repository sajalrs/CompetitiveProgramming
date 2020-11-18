package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    static List<Integer> binTreeArray = new ArrayList<>();
    static int counter = 0;
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

//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        preOrderTraversal(root);
//
//
//
//    }

    public static void preOrderTraversal(TreeNode curNode) {
        counter++;
        if (curNode != null) {
            binTreeArray.add(curNode.val);
            preOrderTraversal(curNode.left);
            preOrderTraversal(curNode.right);
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(3);
        preOrderTraversal(root1);

        System.out.println(Math.log(binTreeArray.size()+1)/Math.log(2) -1);
    }


}
