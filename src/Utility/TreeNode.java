package Utility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode arrayToBinaryTree(int[] arr) {
        if (arr.length == 0) return null;
        int i = 0;
        TreeNode node = new TreeNode(arr[i++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode curNode = queue.poll();
            if (i < arr.length) {
                TreeNode left = new TreeNode(arr[i++]);
                curNode.left = left;
                queue.add(left);
            }

            if (i < arr.length) {
                TreeNode right = new TreeNode(arr[i++]);
                curNode.right = right;
                queue.add(right);
            }
        }

        return node;
    }

    public static int[] binaryTreeToArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        binaryTreeToArrayHelper(list, root);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void binaryTreeToArrayHelper(List<Integer> list, TreeNode node) {
        if (node != null) {
            list.add(node.val);
            binaryTreeToArrayHelper(list, node.left);
            binaryTreeToArrayHelper(list, node.right);
        }
    }
}
