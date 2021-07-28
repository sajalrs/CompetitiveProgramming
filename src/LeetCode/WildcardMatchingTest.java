package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildcardMatchingTest {

    private WildcardMatching wildcardMatching;

    @BeforeEach
    public void setup(){
        wildcardMatching = new WildcardMatching();
    }

    @Test
    @DisplayName("s = \"aa\", p = \"a\"")
    public void test1(){
        assertEquals(false, wildcardMatching.isMatch("aa", "a"));
    }

    @Test
    @DisplayName("s = \"aa\", p = \"*\"")
    public void test2(){
        assertEquals(true, wildcardMatching.isMatch("aa", "*"));
    }

    @Test
    @DisplayName("s = \"cb\", p = \"?a\"")
    public void test3(){
        assertEquals(false, wildcardMatching.isMatch("cb", "?a"));
    }

    @Test
    @DisplayName("s = \"acdcb\", p = \"a*c?b\"")
    public void test4(){
        assertEquals(false, wildcardMatching.isMatch("acdcb", "a*c?b"));
    }

    @Test
    @DisplayName("s = \"adceb\", p = \"*a*b\"")
    public void test5(){
        assertEquals(true, wildcardMatching.isMatch("adceb", "*a*b"));
    }


    @Test
    @DisplayName("s = \"\", p = \"******\"")
    public void test6(){
        assertEquals(true, wildcardMatching.isMatch("", "******"));
    }

    @Test
    @DisplayName("s = \"adceb\", p = \"*a*b\"")
    public void test7(){
        assertEquals(true, wildcardMatching.isMatch("aa", "a*"));
    }

}
