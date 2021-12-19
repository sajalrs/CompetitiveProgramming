package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddSpacesTest {

    private AddSpaces addSpaces;

    @BeforeEach
    public void setup(){
        addSpaces = new AddSpaces();
    }

    @Test
    @DisplayName("Input: s = \"LeetcodeHelpsMeLearn\", spaces = [8,13,15]\n" +
            "Output: \"Leetcode Helps Me Learn\"")
    public void test1() {
        assertEquals(addSpaces.addSpaces("LeetcodeHelpsMeLearn",new int[]{8,13,15}),"Leetcode Helps Me Learn");
    }

    @Test
    @DisplayName("Input: s = \"icodeinpython\", spaces = [1,5,7,9]\n" +
            "Output: \"i code in py thon\"")
    public void test2() {
        assertEquals(addSpaces.addSpaces("icodeinpython",new int[]{1,5,7,9}),"i code in py thon");
    }

    @Test
    @DisplayName("Input: s = \"spacing\", spaces = [0,1,2,3,4,5,6]\n" +
            "Output: \" s p a c i n g\"")
    public void test3() {
        assertEquals(addSpaces.addSpaces("spacing",new int[]{0,1,2,3,4,5,6})," s p a c i n g");
    }
}
