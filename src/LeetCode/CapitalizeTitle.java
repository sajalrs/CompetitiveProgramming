package LeetCode;

import java.util.Locale;

public class CapitalizeTitle {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder sentence = new StringBuilder(title.length());

        for(int i=0; i<words.length-1; i++){
            String word = words[i];
            titleCaseWord(sentence, word);
            sentence.append(" ");
        }

        String lastWord = words[words.length-1];
        titleCaseWord(sentence, lastWord);

        return sentence.toString();
    }

    private void titleCaseWord(StringBuilder sentence, String word) {
        if(!(word.length() <= 2)){
            char firstChar = word.charAt(0);
            String remainingChar = word.substring(1);
            sentence.append(Character.toUpperCase(firstChar));
            sentence.append(remainingChar.toLowerCase());
        }else {
            sentence.append(word.toLowerCase());
        }
    }

    public static void main(String[] args){
        CapitalizeTitle capitalizeTitle = new CapitalizeTitle();
        System.out.println(capitalizeTitle.capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println( capitalizeTitle.capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println( capitalizeTitle.capitalizeTitle("i lOve leetcode"));
    }
}
