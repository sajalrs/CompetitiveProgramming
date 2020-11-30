package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    static void backtrack(List<String> list, String curString, int open, int close, int n){
        if(curString.length() == n*2){
            list.add(curString);
            return;
        }

        if(open < n){
            backtrack(list, curString + "(", open+1, close, n);
        }

        if(open > close){
            backtrack(list, curString+")", open, close+1, n);
        }
    }

    public static void main(String[] args){
        for(String brackets: generateParentheses(3)){
            System.out.println(brackets);
        }
    }
}
