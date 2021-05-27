package CrackingTheCodingInterview;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class IsUnique {

    public boolean isUnique(String str){
        Set<Character> wasEncountered = new HashSet<>();

        for(char c: str.toLowerCase().toCharArray()){
            if(wasEncountered.contains((Character) c)){
                return false;
            }
            wasEncountered.add((Character) c);
        }
        return true;
    }


    public boolean isUniqueInPlace(String str){
        str = str.toLowerCase();
        for(int i=0; i< str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }



    public static void main(String[] args){}
}
