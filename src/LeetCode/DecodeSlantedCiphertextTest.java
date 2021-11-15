package LeetCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeSlantedCiphertextTest {
    DecodeSlantedCiphertext decodeSlantedCiphertext;

    @BeforeEach
    public void setup() {
        decodeSlantedCiphertext = new DecodeSlantedCiphertext();
    }


    @Test
    @DisplayName("Input: encodedText = \"ch   ie   pr\", rows = 3\n" +
            "Output: \"cipher\"")
    public void test1() {
        assertEquals("cipher", decodeSlantedCiphertext.decodeCiphertext("ch   ie   pr", 3));
    }

    @Test
    @DisplayName("Input: encodedText = \"iveo    eed   l te   olc\", rows = 4\n" +
            "Output: \"i love leetcode\"")
    public void test2() {
        assertEquals("i love leetcode", decodeSlantedCiphertext.decodeCiphertext("iveo    eed   l te   olc", 4));
    }

    @Test
    @DisplayName("Input: encodedText = \"coding\", rows = 1\n" +
            "Output: \"coding\"")
    public void test3() {
        assertEquals("coding", decodeSlantedCiphertext.decodeCiphertext("coding", 1));
    }

    @Test
    @DisplayName("Input: encodedText = \" b  ac\", rows = 2\n" +
            "Output: \" abc\"")
    public void test4() {
        assertEquals(" abc", decodeSlantedCiphertext.decodeCiphertext(" b  ac", 2));
    }
}
