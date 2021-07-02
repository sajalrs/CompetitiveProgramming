package LeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PermutationSequenceTest {

    private PermutationSequence permutationSequence;

    @BeforeEach
    public void setup(){
        permutationSequence = new PermutationSequence();
    }

    @Test
    @DisplayName("n=3 k=3")
    public void test1(){
        assertEquals("213", permutationSequence.getPermutation(3,3));
    }

    @Test
    @DisplayName("n=4 k=9")
    public void test2(){
        assertEquals("2314", permutationSequence.getPermutation(4,9));

    }


    @Test
    @DisplayName("n=3 k=1")
    public void test3(){
        assertEquals("123", permutationSequence.getPermutation(3,1));

    }

    @Test
    @DisplayName("n=3 k=5")
    public void test4(){
        assertEquals("312", permutationSequence.getPermutation(3,5));

    }
}
