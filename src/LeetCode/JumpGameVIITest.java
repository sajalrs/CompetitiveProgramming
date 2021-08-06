package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGameVIITest {

    private JumpGameVII jumpGameVII;

    @BeforeEach
    public void setup() {
        jumpGameVII = new JumpGameVII();
    }

    @Test
    @DisplayName("Input: s = \"011010\", minJump = 2, maxJump = 3\n" +
            "Output: true")
    public void test1() {
        assertEquals(true, jumpGameVII.canReach("011010", 2, 3));
    }

    @Test
    @DisplayName("Input: s = \"01101110\", minJump = 2, maxJump = 3\n" +
            "Output: false\n")
    public void test2() {
        assertEquals(false, jumpGameVII.canReach("01101110", 2, 3));
    }

    @Test
    @DisplayName("Input: s = \"000100100010\", minJump = 2, maxJump = 3\n" +
            "Output: false\n")
    public void test3() {
        assertEquals(true, jumpGameVII.canReach("000100100010", 1, 2));
    }


    @Test
    @DisplayName("Input: s = \"00111010\", minJump = 3, maxJump = 5\n" +
            "Output: false\n")
    public void test4() {
        assertEquals(false, jumpGameVII.canReach("00111010", 3, 5));
    }

    @Test
    @DisplayName("Input: s = \"01\", minJump = 1, maxJump = 1\n" +
            "Output: false\n")
    public void test5() {
        assertEquals(false, jumpGameVII.canReach("01", 1, 1));
    }
}
