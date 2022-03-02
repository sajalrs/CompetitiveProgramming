package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromePermutationTest {

    PalindromePermutation palindromePermutation;

    @BeforeEach
    public void setup() {
        palindromePermutation = new PalindromePermutation();
    }

    @Test
    @DisplayName("Input: \"Tact Coa\" Output: true")
    public void test1() {
        assertEquals(true, palindromePermutation.palindromePermutation("Tact Coa"));
    }

    @Test
    @DisplayName("Input: \"Tact%123Coa\" Output: true")
    public void test2() {
        assertEquals(true, palindromePermutation.palindromePermutation("Tact%123Coa"));
    }

    @Test
    @DisplayName("Input: \"Tat%123Coa\" Output: false")
    public void test3() {
        assertEquals(false, palindromePermutation.palindromePermutation("Tat%123Coa"));
    }
}
