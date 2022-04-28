package Practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words.length == 0) return new ArrayList<>();
        Set<String> occurrence = new HashSet<>();
        for (String word : words) {
            occurrence.add(word);
        }
        List<String> toReturn = new ArrayList<>();
        for (String word : words) {
            if (generateSubstringsAndCheck(word, occurrence, new HashSet<>())) toReturn.add(word);
        }
        return toReturn;
    }

    public boolean generateSubstringsAndCheck(String word, Set<String> occurrence, Set<String> dp) {
        if (dp.contains(word)) {
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            String leftString = word.substring(0, i);
            String rightString = word.substring(i);
            if (occurrence.contains(leftString) && (occurrence.contains(rightString) || generateSubstringsAndCheck(rightString, occurrence, dp))) {
                dp.add(word);
                return true;
            }
        }
        return false;
    }

    public boolean generateSubstringsAndCheckFail(String word, Set<String> occurrence, Set<String> dp) {
        if (dp.contains(word)) return true;
        if (occurrence.contains(word)) {
            dp.add(word);
            return true;
        }
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (generateSubstringsAndCheck(left, occurrence, dp) && generateSubstringsAndCheck(right, occurrence, dp)) {
                dp.add(word);
                return true;
            }
        }
        return false;
    }


    public List<String> findAllConcatenatedWordsInADictFail(String[] words) {
        if (words.length == 0) return new ArrayList<>();
        int max = words[0].length();
        List<String> wordsList = new ArrayList<>();
        for (String word : words) {
            wordsList.add(word);
            max = Math.max(word.length(), max);
        }
        Set<String> concatWords = new HashSet<>();
        generateAllPermutationsUnderLength(wordsList, max, concatWords);
        List<String> toReturn = new ArrayList<>();
        for (String word : concatWords) {
            if (concatWords.contains(word)) toReturn.add(word);
        }
        return toReturn;
    }

    public List<String> generateAllPermutationsUnderLength(List<String> words, int max, Set<String> concatWords) {
        if (words.size() == 0) return new ArrayList<>();

        if (words.size() == 1) {
            List<String> list = new ArrayList<>();
            if (words.get(0).length() <= max) list.add(words.get(0));
            return list;
        }


        List<String> returnValue = new ArrayList<>();
        String first = words.get(0);
        if (first.length() <= max) returnValue.add(first);

        List<String> remaining = new ArrayList<>();
        for (int i = 1; i < words.size(); i++) {
            String curWord = words.get(i);
            if (curWord.length() <= max) remaining.add(words.get(i));
        }


        for (String permutation : generateAllPermutationsUnderLength(remaining, max, concatWords)) {
            if (permutation.length() <= max) {
                returnValue.add(permutation);
                if (first.length() <= max) {
                    String newChar = first + permutation;
                    if (newChar.length() <= max) {
                        returnValue.add(newChar);
                        concatWords.add(newChar);
                        String otherWord = permutation + first;
                        returnValue.add(otherWord);
                        concatWords.add(otherWord);
                    }
                    String anotherChar = first + permutation + first;
                    if (anotherChar.length() <= max) {
                        returnValue.add(anotherChar);
                        concatWords.add(anotherChar);
                    }


                }
            }
        }
        return returnValue;
    }

    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        for (String word : concatenatedWords.findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat", "abc"})) {
            System.out.println(word);
        }
        System.out.println();
        for (String word : concatenatedWords.findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"})) {
            System.out.println(word);
        }
    }
}
