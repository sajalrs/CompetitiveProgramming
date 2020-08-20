package LeetCode;
/*
Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

    private static String[] keypad = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static List<String> toReturn;

    public static void main(String[] args){
        List<String> list = letterCombinations("2");
        for(String entry: list){
            System.out.println(entry);
        }

    }

    public static List<String> letterCombinations(String digits){
        toReturn = new LinkedList<String>();

        if(digits.length() == 0){
            return toReturn;
        }

        backTrack(digits,"");
        return toReturn;
    }

    private static void backTrack(String digits, String curString){

        if(digits.length() == 0){
            toReturn.add(curString);
        } else{
            int curNum = Character.getNumericValue(digits.charAt(0));

            String key = keypad[curNum-2];

            for(int i=0; i< key.length();i++){
                backTrack(digits.substring(1,digits.length()), curString+key.charAt(i));
            }
        }


    }

}
