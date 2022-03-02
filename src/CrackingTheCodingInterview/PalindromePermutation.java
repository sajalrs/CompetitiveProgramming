package CrackingTheCodingInterview;

public class PalindromePermutation {
    public boolean palindromePermutation(String word){
        int[] frequency = new int[27];
        for(int i=0; i<word.length(); i++){
            char curChar = Character.toLowerCase(word.charAt(i));
            int alphaIndex = curChar - 'a';
            if(alphaIndex >=0 && alphaIndex<=26) frequency[alphaIndex]++;
        }

        int noOfOdds = 0;
        for(int j=0; j<27; j++){
            if(frequency[j] % 2 != 0) noOfOdds++;
        }

        return noOfOdds <= 1;
    }
}
