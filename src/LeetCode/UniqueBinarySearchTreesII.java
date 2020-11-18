/*

Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {


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

    public static List<TreeNode> generateTrees(int n) {
        if(n < 1){
            return  new ArrayList<>();
        } else {
            return generateTrees(1, n)   ;
        }
    }

    public static List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }

        for(int i = start; i<= end; i++){
            List<TreeNode> leftSubtrees = generateTrees(start, i-1);
            List<TreeNode> rightSubtrees = generateTrees(i+1, end);
            for(TreeNode leftSubtree: leftSubtrees){
                for(TreeNode rightSubtree: rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubtree;
                    root.right = rightSubtree;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        System.out.println(generateTrees(3));
    }



}
