package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsPermutationTest {

    private IsPermutation isPermutaion;

    @BeforeEach
    public void setUp() throws Exception{
        isPermutaion = new IsPermutation();
    }

    @Test
    @DisplayName("Empty string is a permutation of empty String")
    public void emptyStringEmptyString(){
        assertEquals(true, isPermutaion.isPermutation("",""));
    }


    @Test
    @DisplayName("Empty string is not a permutation of space")
    public void emptyStringSpace(){
        assertEquals(false, isPermutaion.isPermutation(""," "));
    }

    @Test
    @DisplayName("Space is a permutation of space")
    public void spaceSpace(){
        assertEquals(true, isPermutaion.isPermutation(" "," "));
    }


    @Test
    @DisplayName("abba is a permutation of abab")
    public void ababAbba(){
        assertEquals(true, isPermutaion.isPermutation("abab","abba"));
    }

    @Test
    @DisplayName("Alphabet and the quick brown fox not exact permutations")
    public void alphaFox(){
        assertEquals(false, isPermutaion.isPermutation("thequickbrownfoxjumpedoverthelazydog","abcdefghijklmnopqrstuvwxyz"));
    }
}

