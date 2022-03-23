package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuccessorTest {
    Successor successor;
    @BeforeEach
    public void setup(){
        successor = new Successor();
    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(arr[0]);
        root.left = new TreeNode(arr[1]);
        root.right = new TreeNode(arr[2]);
        TreeNode key = new TreeNode(arr[3]);
        root.left.left = key;
        TreeNode node = new TreeNode(arr[4]);
        key.right = node;
        assertEquals(node,successor.successor(root, key));
    }
}
