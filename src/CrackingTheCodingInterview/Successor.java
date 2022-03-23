package CrackingTheCodingInterview;

import Utility.TreeNode;

public class Successor {
    public TreeNode successor(TreeNode root, TreeNode key){
        SuccessorNode successor = new SuccessorNode();
        inorderTraversal(root, null, key, successor);
        return successor.value;
    }

    private class SuccessorNode{
        TreeNode value;
    }

    private void inorderTraversal(TreeNode node, TreeNode prev, TreeNode key, SuccessorNode successor){
        if(node != null){
            inorderTraversal(node.left, node, key, successor);
            if(prev == key){
                successor.value = node;
            }
            inorderTraversal(node.right, node, key, successor);
        }
    }
}
