package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithDups {
    public List<String> permutationWithDups(String s){
        return permutationWithDupsAllNMinus1PassDown(s);
    }

    public List<String> permutationWithDupsFirstNMinus1Helper(String s){
        if(s.length() == 1){
            List<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        char firstChar = s.charAt(0);
        String remainingChars = s.substring(1);
        List<String> returnValue = new ArrayList<>();
        for(String word: permutationWithDupsFirstNMinus1Helper(remainingChars)){
            for(int i=0; i<=word.length();i++){
                String newWord = insertCharAt(word, firstChar, i);
                returnValue.add(newWord);
            }
        }
        return returnValue;
    }

    String insertCharAt(String word, char c, int i){
        String start = word.substring(0, i);
        String rem = word.substring(i);
        return start + c + rem;
    }

    public List<String> permutationWithDupsAllNMinus1Helper(String s){
        int length = s.length();
        List<String> result = new ArrayList<>();

        if(length == 0){
            result.add("");
            return result;
        }

        for(int i=0; i<length; i++){
            String before = s.substring(0, i);
            String after = s.substring(i+1, length);
            List<String> partials = permutationWithDupsFirstNMinus1Helper(before + after);

            for(String partial : partials){
                result.add(s.charAt(i) + partial);
            }
        }
        return result;
    }
    public List<String> permutationWithDupsAllNMinus1PassDown(String s){
        List<String> list = new ArrayList<>();
        permutationWithDupsAllNMinus1PassDownHelper("", s, list);
        return list;
    }

    public void permutationWithDupsAllNMinus1PassDownHelper(String prefix, String remainder, List<String> result){
       if(remainder.length() == 0) result.add(prefix);

       int length = remainder.length();
        for(int i=0; i<length; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, length);
            char c = remainder.charAt(i);
            permutationWithDupsAllNMinus1PassDownHelper(prefix + c, before + after, result);
        }
    }


    public static void main(String[] args){
        PermutationWithDups permutationWithDups = new PermutationWithDups();
        for(String permutation: permutationWithDups.permutationWithDups("ram")){
            System.out.println(permutation);
        }
    }
}
