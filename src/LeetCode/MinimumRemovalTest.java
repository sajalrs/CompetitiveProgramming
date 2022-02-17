package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumRemovalTest {

    private MinimumRemoval minimumRemoval;
    @BeforeEach
    public void setup(){
        minimumRemoval = new MinimumRemoval();
    }

    @Test
    @DisplayName("Input: beans = [4,1,6,5]\n" +
            "Output: 4\n" +
            "Explanation: \n" +
            "- We remove 1 bean from the bag with only 1 bean.\n" +
            "  This results in the remaining bags: [4,0,6,5]\n" +
            "- Then we remove 2 beans from the bag with 6 beans.\n" +
            "  This results in the remaining bags: [4,0,4,5]\n" +
            "- Then we remove 1 bean from the bag with 5 beans.\n" +
            "  This results in the remaining bags: [4,0,4,4]\n" +
            "We removed a total of 1 + 2 + 1 = 4 beans to make the remaining non-empty bags have an equal number of beans.\n" +
            "There are no other solutions that remove 4 beans or fewer.")
    public void test1(){
        assertEquals(4,minimumRemoval.minimumRemoval(new int[]{4,1,6,5}));
    }

    @Test
    @DisplayName("Input: beans = [2,10,3,2]\n" +
            "Output: 7\n" +
            "Explanation:\n" +
            "- We remove 2 beans from one of the bags with 2 beans.\n" +
            "  This results in the remaining bags: [0,10,3,2]\n" +
            "- Then we remove 2 beans from the other bag with 2 beans.\n" +
            "  This results in the remaining bags: [0,10,3,0]\n" +
            "- Then we remove 3 beans from the bag with 3 beans. \n" +
            "  This results in the remaining bags: [0,10,0,0]\n" +
            "We removed a total of 2 + 2 + 3 = 7 beans to make the remaining non-empty bags have an equal number of beans.\n" +
            "There are no other solutions that removes 7 beans or fewer.")
    public void test2(){
        assertEquals(7,minimumRemoval.minimumRemoval(new int[]{2,10,3,2}));
    }
}
