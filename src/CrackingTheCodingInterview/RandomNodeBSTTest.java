package CrackingTheCodingInterview;

import Utility.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomNodeBSTTest {
    @Test
    public void test1() {
        int[] nums = new int[]{12, 4, -1, 0, 24, 5, 2, -12, 4};
        RandomNodeBST randomNodeBST = new RandomNodeBST();
        for (int num : nums) {
            randomNodeBST.insert(num);
        }
        TreeNode root = randomNodeBST.getRoot();
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);

        int[] listArray = new int[sorted.size()];
        for(int i=0; i<sorted.size(); i++){
            listArray[i] = sorted.get(i);
        }
        Arrays.sort(nums);
        assertArrayEquals(nums, listArray);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{12, 4, -1, 0, 24, 5, 2, -12, 4};
        RandomNodeBST randomNodeBST = new RandomNodeBST();
        for (int num : nums) {
            randomNodeBST.insert(num);
        }
        randomNodeBST.delete(12);
        TreeNode root = randomNodeBST.getRoot();
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);

        int[] listArray = new int[sorted.size()];
        for(int i=0; i<sorted.size(); i++){
            listArray[i] = sorted.get(i);
        }
        assertArrayEquals(new int[]{-12, -1, 0, 2, 4, 4, 5, 24}, listArray);
    }

    @Test
    public void test3() {
        int[] nums = new int[]{12, 4, -1, 0, 24, 5, 2, -12, 4};
        RandomNodeBST randomNodeBST = new RandomNodeBST();
        for (int num : nums) {
            randomNodeBST.insert(num);
        }
        randomNodeBST.delete(2);

        TreeNode root = randomNodeBST.getRoot();
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);

        int[] listArray = new int[sorted.size()];
        for(int i=0; i<sorted.size(); i++){
            listArray[i] = sorted.get(i);
        }
        assertArrayEquals(new int[]{-12, -1, 0, 4, 4, 5,12, 24}, listArray);
    }

    @Test
    public void test4() {
        int[] nums = new int[]{12, 4, -1, 0, 24, 5, 2, -12, 4};
        RandomNodeBST randomNodeBST = new RandomNodeBST();
        for (int num : nums) {
            randomNodeBST.insert(num);
        }
        randomNodeBST.delete(4);
        randomNodeBST.delete(4);
        TreeNode root = randomNodeBST.getRoot();
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);

        int[] listArray = new int[sorted.size()];
        for(int i=0; i<sorted.size(); i++){
            listArray[i] = sorted.get(i);
        }
        assertArrayEquals(new int[]{-12, -1, 0, 2, 5, 12, 24}, listArray);
    }

    @Test
    public void test5() {
        int[] nums = new int[]{12, 4, -1, 0, 24, 5, 2, -12, 4};
        RandomNodeBST randomNodeBST = new RandomNodeBST();
        for (int num : nums) {
            randomNodeBST.insert(num);
        }
        TreeNode negativeOne = randomNodeBST.find(-1);
        assertEquals(negativeOne.left.val, -12);
        assertEquals(negativeOne.right.val, 0);
    }

    @Test
    public void test6() {
        int[] nums = new int[]{12, 4, -1, 0, 24, 5, 2, -12, 4};
        RandomNodeBST randomNodeBST = new RandomNodeBST();
        for (int num : nums) {
            randomNodeBST.insert(num);
        }

        System.out.println(randomNodeBST.getRandomNode());
    }

    private void inOrderTraversal(TreeNode node, List<Integer> nums) {
        if (node != null) {
            inOrderTraversal(node.left, nums);
            nums.add(node.val);
            inOrderTraversal(node.right, nums);
        }
    }
}
