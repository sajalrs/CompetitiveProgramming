package LeetCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChalkReplacerTest {

    ChalkReplacer chalkReplacer;
    @BeforeEach
    public void setup(){
        chalkReplacer = new ChalkReplacer();
    }

    @Test
    @DisplayName("Test 1")
    public void test1(){
        int[] chalk = new int[]{5,1,5};
        int k = 22;
        assertEquals(0,chalkReplacer.chalkReplacer(chalk, k));
    }


    @Test
    @DisplayName("Test 2")
    public void test2(){
        int[] chalk = new int[]{3,4,1,2};
        int k = 25;
        assertEquals(1,chalkReplacer.chalkReplacer(chalk, k));
    }
}
