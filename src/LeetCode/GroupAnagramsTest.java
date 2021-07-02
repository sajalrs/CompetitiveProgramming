package LeetCode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static  org.junit.jupiter.api.Assertions.assertArrayEquals;
import static  org.junit.jupiter.api.Assertions.assertEquals;

public class GroupAnagramsTest {

    GroupAnagrams groupAnagrams;

    @BeforeEach
    public void setup(){
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    @DisplayName("strs = [\"eat\",\"tea\",\"tan\",\"ate\",\"nat\",\"bat\"]")
    public void test1(){

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[][] ans = new String[][]{new String[]{"bat"}, new String[]{"nat","tan"},new String[]{"ate","eat","tea"}};


        passesTest(strs, ans);

    }

    @Test
    @DisplayName("strs = [\"\"]")
    public void test2(){
        String[] strs = new String[]{""};
        String[][] ans = new String[][]{new String[]{""}};


        passesTest(strs, ans);
    }

    @Test
    @DisplayName("strs = [\"a\"]\n")
    public void test3(){
        String[] strs = new String[]{"a"};
        String[][] ans = new String[][]{new String[]{"a"}};


        passesTest(strs, ans);
    }

    private void passesTest(String[] strs, String[][] ans) {
        List<List<String>> anagramsList = groupAnagrams.groupAnagrams(strs);

        int count = 0;
        for(List<String> anagrams: anagramsList){
            assertArrayEquals(ans[count], anagrams.toArray());
            count++;
        }

        assertEquals(count, ans.length);
    }
}
