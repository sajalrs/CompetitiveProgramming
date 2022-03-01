package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class URLifyTest {

    URLify urlify;
    @BeforeEach
    public void setup(){
        urlify = new URLify();
    }

    @Test
    @DisplayName("Input: \"sajal satyal\" Output: \"sajal%20satyal\"")
    public void test1(){
        assertEquals("sajal%20satyal", urlify.urlify("sajal satyal"));
    }

    @Test
    @DisplayName("Input: \"sajal satyal is a big boy\" Output: \"sajal%20satyal%20is%20a%20big%20boy\"")
    public void test2(){
        assertEquals("sajal%20satyal%20is%20a%20big%20boy", urlify.urlify("sajal satyal is a big boy"));
    }

}
