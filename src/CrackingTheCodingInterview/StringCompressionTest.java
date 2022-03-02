package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {

    StringCompression stringCompression;
    @BeforeEach
    public void setup(){
        stringCompression = new StringCompression();
    }

    @Test
    @DisplayName("Input: aabcccccaaa Output: a2b1c5a3")
    public void test1(){
        assertEquals("a2b1c5a3", stringCompression.stringCompression("aabcccccaaa"));
    }

    @Test
    @DisplayName("Input: abcd Output: abcd")
    public void test2(){
        assertEquals("abcd", stringCompression.stringCompression("abcd"));
    }
}
