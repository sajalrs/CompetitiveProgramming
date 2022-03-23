package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateBSTTest {
    ValidateBST validateBST;
    @BeforeEach
    public void setup(){
        validateBST = new ValidateBST();
    }

    @Test
    public void test1(){
        int[] arr = new int[]{2,1,3};
        assert validateBST.validateBST(TreeNode.arrayToBinaryTree(arr));
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5};
        assert !validateBST.validateBST(TreeNode.arrayToBinaryTree(arr));
    }

    @Test
    public void test3(){
        int[] arr = new int[]{2,1,3};
        assert validateBST.validateBSTNSpace(TreeNode.arrayToBinaryTree(arr));
    }

    @Test
    public void test4(){
        int[] arr = new int[]{1,2,3,4,5};
        assert !validateBST.validateBSTNSpace(TreeNode.arrayToBinaryTree(arr));
    }

    @Test
    public void test5(){
        int[] arr = new int[]{2,1,3};
        assert validateBST.validateBSTMinMax(TreeNode.arrayToBinaryTree(arr));
    }

    @Test
    public void test6(){
        int[] arr = new int[]{1,2,3,4,5};
        assert !validateBST.validateBSTMinMax(TreeNode.arrayToBinaryTree(arr));
    }
}
