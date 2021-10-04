package LeetCode;



public class MinimumMovesToConvertString {
    public int minimumMoves(String s) {
        int count = 0;
        int i =0;
        while(i<s.length()){
            if(s.charAt(i) == 'X'){
                i+=3;
                count++;
                continue;
            }
            i++;
        }
        return count;
    }


}
