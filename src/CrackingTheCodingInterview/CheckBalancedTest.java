package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBalancedTest {
    CheckBalanced checkBalanced;
    @BeforeEach
    public void setup(){
        checkBalanced = new CheckBalanced();
    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(arr[0]);
        TreeNode prev = root;
        for(int i=1; i<arr.length; i++){
            prev.left = new TreeNode(arr[i]);
            prev = prev.left;
        }
        assertEquals(false, checkBalanced.checkBalanced(root));
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(arr[0]);
        root.left = new TreeNode(arr[1]);
        root.right = new TreeNode(arr[2]);
        root.left.left = new TreeNode(arr[3]);
        root.right.right = new TreeNode(arr[4]);
        assertEquals(true, checkBalanced.checkBalanced(root));
    }

    @Test
    public void test3(){
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(arr[0]);
        TreeNode prev = root;
        for(int i=1; i<arr.length; i++){
            prev.left = new TreeNode(arr[i]);
            prev = prev.left;
        }
        assertEquals(false, checkBalanced.checkBalancedN2(root));
    }

    @Test
    public void test4(){
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(arr[0]);
        root.left = new TreeNode(arr[1]);
        root.right = new TreeNode(arr[2]);
        root.left.left = new TreeNode(arr[3]);
        root.right.right = new TreeNode(arr[4]);
        assertEquals(true, checkBalanced.checkBalancedN2(root));
    }
}
