package LeetCode;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DivideStringsTest {

    DivideStrings divideStrings;
    @BeforeEach
    public void setup(){
        divideStrings = new DivideStrings();
    }

    @Test
    @DisplayName("Input: s = \"abcdefghi\", k = 3, fill = \"x\"\n" +
            "Output: [\"abc\",\"def\",\"ghi\"]\n" +
            "Explanation:\n" +
            "The first 3 characters \"abc\" form the first group.\n" +
            "The next 3 characters \"def\" form the second group.\n" +
            "The last 3 characters \"ghi\" form the third group.\n" +
            "Since all groups can be completely filled by characters from the string, we do not need to use fill.\n" +
            "Thus, the groups formed are \"abc\", \"def\", and \"ghi\".")
    public void test1(){
        assertArrayEquals(new String[]{"abc","def","ghi"}, divideStrings.divideString( "abcdefghi", 3,'x'));
    }

    @Test
    @DisplayName("Input: s = \"abcdefghij\", k = 3, fill = \"x\"\n" +
            "Output: [\"abc\",\"def\",\"ghi\",\"jxx\"]\n" +
            "Explanation:\n" +
            "Similar to the previous example, we are forming the first three groups \"abc\", \"def\", and \"ghi\".\n" +
            "For the last group, we can only use the character 'j' from the string. To complete this group, we add 'x' twice.\n" +
            "Thus, the 4 groups formed are \"abc\", \"def\", \"ghi\", and \"jxx\".")
    public void test2(){
        assertArrayEquals(new String[]{"abc","def","ghi","jxx"}, divideStrings.divideString( "abcdefghij", 3,'x'));
    }
}
