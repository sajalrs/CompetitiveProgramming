package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimalTreeTest {
    MinimalTree minimalTree;
    @BeforeEach
    public void setup(){
        minimalTree = new MinimalTree();
    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3,4,5};
        MinimalTree.TreeNode node = minimalTree.minimalTree(arr);
        assertEquals(3,node.val);
        assertEquals(1, node.left.val);
        assertEquals(4,node.right.val);
        assertEquals(2,node.left.right.val);
        assertEquals(5,node.right.right.val);
    }
}
