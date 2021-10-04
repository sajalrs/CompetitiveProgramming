package LeetCode;

public class CheckOnesSegment {
    public boolean checkOnesSegment(String s) {
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '0' && s.charAt(i+1) =='1') return false;
        }

        return true;

    }

    public static void main(String[] args){
        CheckOnesSegment checkOnesSegment = new CheckOnesSegment();
        System.out.println(checkOnesSegment.checkOnesSegment("1001"));
        System.out.println(checkOnesSegment.checkOnesSegment("110"));
        System.out.println(checkOnesSegment.checkOnesSegment("101"));
        System.out.println(checkOnesSegment.checkOnesSegment("1101"));
        System.out.println(checkOnesSegment.checkOnesSegment("11011"));
        System.out.println(checkOnesSegment.checkOnesSegment("0"));
        System.out.println(checkOnesSegment.checkOnesSegment("11"));
        System.out.println(checkOnesSegment.checkOnesSegment("1"));
        System.out.println(checkOnesSegment.checkOnesSegment("10"));
        System.out.println(checkOnesSegment.checkOnesSegment("10110000"));




    }
}
