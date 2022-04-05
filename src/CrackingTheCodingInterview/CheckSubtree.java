package CrackingTheCodingInterview;

import Utility.TreeNode;

public class CheckSubtree {

    public boolean checkSubtree(TreeNode root, TreeNode subTreeRoot){
        return checkSubtreeHelper(root, subTreeRoot) || checkIsSubtree(root, subTreeRoot);
    }

    private boolean checkSubtreeHelper(TreeNode node, TreeNode subTreeRoot) {
        if(node != null){
            boolean left = checkIsSubtree(node.left, subTreeRoot);
            if(node.val != subTreeRoot.val) return false;
            boolean right = checkIsSubtree(node.right, subTreeRoot);
            return left && right;
        }
        return subTreeRoot == null;
    }

    public boolean checkIsSubtree(TreeNode node, TreeNode subTreeNode) {
        if(node != null){
            if(subTreeNode == null) return true;
            boolean left = checkIsSubtree(node.left, subTreeNode.left);
            if(node.val != subTreeNode.val) return  false;
            boolean right = checkIsSubtree(node.right, subTreeNode.right);
            return left && right;
        }
        return subTreeNode == null;
    }
}
