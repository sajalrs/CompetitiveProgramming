package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckSubtreeTest {
    CheckSubtree checkSubtree;
    @BeforeEach
    public void setup(){
        checkSubtree = new CheckSubtree();
    }

    @Test
    public void test1(){
        TreeNode root = TreeNode.arrayToBinaryTree(new int[]{1,3,4,5,2});
        TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper();
        inorderTraversal(root, treeNodeWrapper);
        TreeNode subTreeRoot = TreeNode.arrayToBinaryTree(new int[]{4,1,0,3,7});
        treeNodeWrapper.node.right = subTreeRoot;
        assertEquals(true, checkSubtree.checkIsSubtree(root, subTreeRoot));
    }

    private class TreeNodeWrapper{
        TreeNode node;
    }

    private void inorderTraversal(TreeNode node, TreeNodeWrapper treeNodeWrapper){
        if(node != null){
            inorderTraversal(node.left, treeNodeWrapper);
            treeNodeWrapper.node = node;
            inorderTraversal(node.right, treeNodeWrapper);
        }
    }
}
