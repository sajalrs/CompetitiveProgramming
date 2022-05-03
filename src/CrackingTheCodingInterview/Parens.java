package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parens {
    public void parens(int n){
        List<String> list = new ArrayList<>();
        parensHelperString(n, n, 0, "", list);
        for(String paren: list){
            System.out.println(paren);
        }
    }

    public Set<String> parensHelperWasteful(int n){
        Set<String> returnValue = new HashSet<>();
        if(n == 1) {
            returnValue.add("()");
            return returnValue;
        }

        for(String parens:  parensHelperWasteful(n-1)){
            for(int i=0; i<parens.length(); i++){
                returnValue.add(parens.substring(0, i) + "()" + parens.substring(i));
            }
        }
        return returnValue;
    }

    public void parensHelper(int left, int right, int i, char[] curString, List<String> parens){
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0){
            parens.add(String.valueOf(curString));
            return;
        }

        if(left>0){
            curString[i] = '(';
            parensHelper(left-1, right, i+1, curString, parens);
        }

        if(right>left){
            curString[i] = ')';
            parensHelper(left, right-1, i+1, curString, parens);
        }
    }

    public void parensHelperString(int left, int right, int i, String curString, List<String> parens){
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0){
            parens.add(curString);
            return;
        }

        if(left>0){
            parensHelperString(left-1, right, i+1, curString.substring(0,i) + '(' + curString.substring(i), parens);
        }

        if(right>left){
            parensHelperString(left, right-1, i+1, curString.substring(0,i) + ')' + curString.substring(i), parens);
        }
    }

    public static void main(String[] args){
        Parens parens = new Parens();
        parens.parens(3);
    }
}
