package CrackingTheCodingInterview;

import Utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    public boolean validateBST(TreeNode root) {
        if (root == null) return true;
        Previous previous = new Previous();
        return inorderTraversal(root, previous);
    }

    public boolean validateBSTNSpace(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalNSpace(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void inorderTraversalNSpace(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversalNSpace(node.left, list);
            list.add(node.val);
            inorderTraversalNSpace(node.right, list);
        }
    }

    private class Previous {
        int value = Integer.MIN_VALUE;
    }

    private boolean inorderTraversal(TreeNode node, Previous previous) {
        if (node != null) {
            boolean left = inorderTraversal(node.left, previous);
            if (node.val <= previous.value) return false;
            previous.value = node.val;
            boolean right = inorderTraversal(node.right, previous);
            return left && right;
        }
        return true;
    }

    public boolean validateBSTMinMax(TreeNode root) {
        return validateBSTMinMaxHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateBSTMinMaxHelper(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val < min || node.val > max) return false;
        return validateBSTMinMaxHelper(node.left, min, node.val) &&
                validateBSTMinMaxHelper(node.right, node.val, max);
    }
}
