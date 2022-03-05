package CrackingTheCodingInterview;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringRotationTest {

    StringRotation stringRotation;
    @BeforeEach
    public void setup(){
        stringRotation = new StringRotation();
    }

    @Test
    @DisplayName("Input: s1=waterbottle, s2=erbottlewat Output:true")
    public void test1(){
        assertEquals(true,stringRotation.stringRotation("waterbottle","erbottlewat"));
    }

    @Test
    @DisplayName("Input: s1=iamsam, s2=samiam Output:true")
    public void test2(){
        assertEquals(true,stringRotation.stringRotation("iamsam","samiam"));
    }

    @Test
    @DisplayName("Input: s1=yoyoma, s2=yomayo Output:false")
    public void test3(){
        assertEquals(true,stringRotation.stringRotation("yoyoma","yomayo"));
    }


    @Test
    @DisplayName("Input: s1=sajal, s2=shyam Output:false")
    public void test4(){
        assertEquals(false,stringRotation.stringRotation("sajal","shyam"));
    }
}
