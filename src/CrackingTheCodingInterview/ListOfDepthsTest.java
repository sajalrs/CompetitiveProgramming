package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ListOfDepthsTest {

    ListOfDepths listOfDepths;

    @BeforeEach
    public void setup() {
        listOfDepths = new ListOfDepths();
    }

    @Test
    public void test1() {
        TreeNode root = TreeNode.arrayToBinaryTree(new int[]{1, 2, 3});
        List<List<Integer>> listOfLists = listOfDepths.listOfDepths(root);
        assertArrayEquals(new Integer[]{1}, listOfLists.get(0).toArray());
        assertArrayEquals(new Integer[]{2, 3}, listOfLists.get(1).toArray());
    }

    @Test
    public void test2() {
        TreeNode root = TreeNode.arrayToBinaryTree(new int[]{1, 2, 3, 4, 5, 6});
        List<List<Integer>> listOfLists = listOfDepths.listOfDepths(root);
        assertArrayEquals(new Integer[]{1}, listOfLists.get(0).toArray());
        assertArrayEquals(new Integer[]{2, 3}, listOfLists.get(1).toArray());
        assertArrayEquals(new Integer[]{4, 5, 6}, listOfLists.get(2).toArray());
    }

    @Test
    public void test3() {
        TreeNode root = TreeNode.arrayToBinaryTree(new int[]{1, 2, 3, 4, 5, 6});
        List<List<Integer>> listOfLists = listOfDepths.listOfDepthsBST(root);
        assertArrayEquals(new Integer[]{1}, listOfLists.get(0).toArray());
        assertArrayEquals(new Integer[]{2, 3}, listOfLists.get(1).toArray());
        assertArrayEquals(new Integer[]{4, 5, 6}, listOfLists.get(2).toArray());
    }

    @Test
    public void test4() {
        TreeNode root = TreeNode.arrayToBinaryTree(new int[]{1, 2, 3});
        List<List<Integer>> listOfLists = listOfDepths.listOfDepthsBST(root);
        assertArrayEquals(new Integer[]{1}, listOfLists.get(0).toArray());
        assertArrayEquals(new Integer[]{2, 3}, listOfLists.get(1).toArray());
    }

    public static void main(String[] args) {
        ListOfDepthsTest listOfDepthsTest = new ListOfDepthsTest();
        System.out.println(Arrays.toString(TreeNode.binaryTreeToArray(TreeNode.arrayToBinaryTree(new int[]{1, 2, 3}))));
    }
}
