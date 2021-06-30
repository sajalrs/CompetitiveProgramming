package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    public class TreeNode {
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
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        preOrderTraversal(root, new ArrayList<>(),  targetSum, list);
        return list;
    }


    public void preOrderTraversal(TreeNode curNode, List<Integer> list, int targetSum, List<List<Integer>> toReturn) {
        if (curNode == null) {
            return;
        }

       list.add(curNode.val);
        if (curNode.val == targetSum && curNode.left == null && curNode.right == null) {
            toReturn.add(list);
            return;
        }
        preOrderTraversal(curNode.left, new ArrayList<>(list), targetSum - curNode.val, toReturn);
        preOrderTraversal(curNode.right, new ArrayList<>(list), targetSum - curNode.val, toReturn);
    }


}
