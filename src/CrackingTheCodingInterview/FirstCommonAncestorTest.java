package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstCommonAncestorTest {
    FirstCommonAncestor firstCommonAncestor;

    @BeforeEach
    public void setup(){
        firstCommonAncestor = new FirstCommonAncestor();
    }

    @Test
    public void test1(){
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        assertEquals(root, firstCommonAncestor.FirstCommonAncestor(root, left, right));
    }


    @Test
    public void test2(){
        TreeNode root = TreeNode.arrayToBinaryTree(new int[]{1,3,4,5,2});
        TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper();
        inorderTraversal(root, treeNodeWrapper);
        TreeNode subTreeRoot1 = TreeNode.arrayToBinaryTree(new int[]{4,1,0,3,7});
        TreeNode subTreeRoot2 = TreeNode.arrayToBinaryTree(new int[]{12,2,3,5,9});
        treeNodeWrapper.node.left = subTreeRoot1;
        treeNodeWrapper.node.right = subTreeRoot2;
        TreeNode commonAncestor = firstCommonAncestor.FirstCommonAncestor(root, subTreeRoot1, subTreeRoot2);
        assertEquals(treeNodeWrapper.node, commonAncestor);
    }

    private class TreeNodeWrapper{
        TreeNode node;
    }

    private void inorderTraversal(TreeNode node,TreeNodeWrapper treeNodeWrapper){
        if(node != null){
            inorderTraversal(node.left, treeNodeWrapper);
            treeNodeWrapper.node = node;
            inorderTraversal(node.right, treeNodeWrapper);
        }
    }
}
