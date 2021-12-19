package LeetCode;

public class FirstPalindrome {
    public String firstPalindrome(String[] words) {
        String toReturn = "";
        for(String word: words){
            if(isPalindrome(word)){
                toReturn = word;
                break;
            }
        }
        return toReturn;
    }

    private boolean isPalindrome(String word){
        if(word.length() == 0) return true;
        int mid = Math.floorDiv(word.length(),2);
        int i = 0;
        int j = word.length() - 1;

        while(i <= mid){
            if(word.charAt(i) != word.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args){
        FirstPalindrome firstPalindrome = new FirstPalindrome();
        System.out.println(firstPalindrome.firstPalindrome(new String[]{"def","ghi"}));
    }
}


