package CrackingTheCodingInterview;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimalTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode minimalTree(int[] arr) {
        return minimalTreeHelper(arr, 0, arr.length - 1);
    }

    private TreeNode minimalTreeHelper(int[] arr, int l, int r) {
        if (l > r) return null;
        int m = (l + r) / 2;
        TreeNode cur = new TreeNode(arr[m]);
        cur.left = minimalTreeHelper(arr, l, m - 1);
        cur.right = minimalTreeHelper(arr, m + 1, r);
        return cur;
    }

    public static void inorderTraversal(TreeNode cur){
        if(cur != null){
            inorderTraversal(cur.left);
            System.out.println(cur.val);
            inorderTraversal(cur.right);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5};
        MinimalTree minimalTree = new MinimalTree();
        TreeNode node = minimalTree.minimalTree(arr);
        inorderTraversal(node);
    }
}
