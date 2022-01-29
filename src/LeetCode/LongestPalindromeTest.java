package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeTest {
    LongestPalindrome longestPalindrome;
    @BeforeEach
    public void setup(){
        longestPalindrome = new LongestPalindrome();
    }

    @Test
    @DisplayName("Input: words = [\"lc\",\"cl\",\"gg\"]\n" +
            "Output: 6\n" +
            "Explanation: One longest palindrome is \"lc\" + \"gg\" + \"cl\" = \"lcggcl\", of length 6.\n" +
            "Note that \"clgglc\" is another longest palindrome that can be created.")
    public void test1(){
        assertEquals(6, longestPalindrome.longestPalindrome(new String[]{"lc","cl","gg"}));
    }

    @Test
    @DisplayName("Input: words = [\"ab\",\"ty\",\"yt\",\"lc\",\"cl\",\"ab\"]\n" +
            "Output: 8\n" +
            "Explanation: One longest palindrome is \"ty\" + \"lc\" + \"cl\" + \"yt\" = \"tylcclyt\", of length 8.\n" +
            "Note that \"lcyttycl\" is another longest palindrome that can be created.")
    public void test2(){
        assertEquals(8, longestPalindrome.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
    }

    @Test
    @DisplayName("Input: words = [\"cc\",\"ll\",\"xx\"]\n" +
            "Output: 2\n" +
            "Explanation: One longest palindrome is \"cc\", of length 2.\n" +
            "Note that \"ll\" is another longest palindrome that can be created, and so is \"xx\".")
    public void test3(){
        assertEquals(2, longestPalindrome.longestPalindrome(new String[]{"cc","ll","xx"}));
    }
}
