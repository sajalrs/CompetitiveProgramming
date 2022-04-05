package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathsWithSumTest {
    PathsWithSum pathsWithSum;
    @BeforeEach
    public void setup(){
        pathsWithSum = new PathsWithSum();
    }

    @Test
    public void test1(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);

        assertEquals(2,pathsWithSum.pathsWithSum(root, 10));
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);

        assertEquals(1,pathsWithSum.pathsWithSum(root, 10));
    }


    @Test
    public void test3(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        assertEquals(2,pathsWithSum.pathsWithSum(root, 10));
    }

    @Test
    public void test4(){
        assertEquals(0,pathsWithSum.pathsWithSum(null, 10));
    }

    @Test
    public void test5(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        assertEquals(3,pathsWithSum.pathsWithSum(root, 10));
    }
}
