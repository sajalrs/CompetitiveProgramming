package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCollisionsTest {
    CountCollisions countCollisions;

    @BeforeEach
    public void setup() {
        countCollisions = new CountCollisions();
    }

    @Test
    public void test1() {
        assertEquals(5, countCollisions.countCollisions("RLRSLL"));
    }

    @Test
    public void test2() {
        assertEquals(0, countCollisions.countCollisions("LLRR"));
    }
}
