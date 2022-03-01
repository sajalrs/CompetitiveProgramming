package CrackingTheCodingInterview;

import java.lang.reflect.Array;

public class URLify {

    public String urlify(String words) {
        int noOfSpaces = 0;
        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == ' ') noOfSpaces++;
        }

        char[] charString = new char[words.length() + (2 * noOfSpaces)];
        int i = 0;
        for (; i < words.length(); i++) {
            charString[i] = words.charAt(i);
        }
        for (; i < charString.length; i++) {
            charString[i] = ' ';
        }

        return urlify(charString);
    }

    private String urlify(char[] words) {
        int noOfSpaces = 0;
        int i = words.length - 1;
        while (words[i] == ' ') {
            i--;
        }
        int curIndex = i;
        for (; i > 0; i--) {
            if (words[i] == ' ') noOfSpaces++;
        }

        while (noOfSpaces > 0) {
            char curChar = words[curIndex];
            if (curChar == ' ') {
                noOfSpaces--;
                words[curIndex + (2 * noOfSpaces)] = '%';
                words[curIndex + (2 * noOfSpaces) + 1] = '2';
                words[curIndex + (2 * noOfSpaces) + 2] = '0';

            } else {
                char temp = words[curIndex + (2 * noOfSpaces)];
                words[curIndex + (2 * noOfSpaces)] = words[curIndex];
                words[curIndex] = temp;
            }
            curIndex--;
        }

        return String.valueOf(words);
    }
}
