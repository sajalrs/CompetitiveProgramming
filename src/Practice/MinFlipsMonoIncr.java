package Practice;

public class MinFlipsMonoIncr {
    public int minFlipsMonoIncr(String s) {
        int right = 0;
        for(int i=s.length()-1; i>0; i--){
            if(s.charAt(i) == '1') right++;
        }

        int left = s.charAt(0) == '1'? 1: 0;
        int min = ((s.length() - 1) - right) + left;

        if(left == 1){
            min = Math.min(min, s.length() - (1) - right);
        }
        if(right == 0){
            min = Math.min(min, left);
        }

        for(int i=1; i<s.length(); i++){
            char curChar = s.charAt(i);
            if(curChar == '1') {
                left++;
                right--;
            }
            int curMin = (s.length() - (i+1)) - right + left;
            if(left == i+1){
                curMin = Math.min(curMin, s.length() - (i+1) - right);
            }
            if(right == 0){
                curMin = Math.min(curMin, left);
            }

            min = Math.min(curMin, min);
        }
        return min;
    }

    public static void main(String[] args){
        MinFlipsMonoIncr minFlipsMonoIncr = new MinFlipsMonoIncr();
//        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("00110"));
//        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("010110"));
//        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("00011000"));
        System.out.println(minFlipsMonoIncr.minFlipsMonoIncr("11011"));
    }
}
