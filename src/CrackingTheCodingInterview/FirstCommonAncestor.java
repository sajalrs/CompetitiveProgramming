package CrackingTheCodingInterview;

import Utility.TreeNode;

public class FirstCommonAncestor {
    public TreeNode FirstCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        preorderTraversal(root, one, two, new TreeNodeWrapper());
        TreeNode curNode = one;
        while (curNode != null) {
            if (curNode.left != null && !(curNode.left.right == curNode)) return curNode.left;
            curNode = curNode.left;
        }

        curNode = two;
        while (curNode != null) {
            if (curNode.left != null && !(curNode.left.right == curNode)) return curNode.left;
            curNode = curNode.left;
        }
        return null;
    }

    private class TreeNodeWrapper {
        TreeNode node;

        TreeNodeWrapper(TreeNode treeNode) {
            this.node = treeNode;
        }

        TreeNodeWrapper() {
        }
    }

    private void preorderTraversal(TreeNode node, TreeNode one, TreeNode two, TreeNodeWrapper prev) {
        if (node != null) {
            TreeNode leftNode = node.left;
            node.left = prev.node;
            TreeNode rightNode = node.right;
            if (prev.node != null) prev.node.right = node;
            if (node == one || node == two) return;
            preorderTraversal(leftNode, one, two, new TreeNodeWrapper(node));
            preorderTraversal(rightNode, one, two, new TreeNodeWrapper(node));
        }
    }

}
