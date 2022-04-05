package CrackingTheCodingInterview;

import Utility.TreeNode;
import com.sun.source.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BSTSequencesTest {
    BSTSequences bstSequences;
    @BeforeEach
    public void setup(){
        bstSequences = new BSTSequences();
    }

    @Test
    public void test1(){
        List<int[]> sequences = bstSequences.BSTSequences(TreeNode.arrayToBinaryTree(new int[]{2,1,3}));
        for(int[] sequence: sequences){
            System.out.println(Arrays.toString(sequence));
        }

    }
}
