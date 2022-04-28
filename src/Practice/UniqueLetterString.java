package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString {

    public int uniqueLetterString(String s) {
        return countUniqueCharsInSubString(s);
    }

    public int countUniqueCharsInSubStringTrivial(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int[] used = new int[26];
                for (int k = i; k <= j; k++) {
                    char curChar = s.charAt(k);
                    int curIndex = curChar - 'A';
                    if (used[curIndex] == 0) {
                        count++;
                        used[curIndex] = 1;
                    } else if (used[curIndex] == 1) {
                        count--;
                        used[curIndex] = -1;
                    }

                }
            }
        }
        return count;
    }

    public int countUniqueCharsInSubString(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i), key -> new ArrayList<>()).add(i);
        }

        int sum=0;
        for(List<Integer> indexes: map.values()){
            for(int i=0; i<indexes.size(); i++){
                int left = i == 0?  indexes.get(i) + 1: indexes.get(i) - indexes.get(i-1);
                int right= i== indexes.size()-1? s.length() - indexes.get(i): indexes.get(i+1) - indexes.get(i);
                sum += left * right;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        UniqueLetterString uniqueLetterString = new UniqueLetterString();
        System.out.println(uniqueLetterString.uniqueLetterString("ABC"));
        System.out.println(uniqueLetterString.uniqueLetterString("ABA"));
        System.out.println(uniqueLetterString.uniqueLetterString("LEETCODE"));
    }
}
