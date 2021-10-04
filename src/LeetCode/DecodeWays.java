package LeetCode;

public class DecodeWays {
    public static int numDecodings(String s) {
        return numDecodingsRecursice(s, 0);
    }

    public static int numDecodingsRecursice(String s, int curIndex) {
        if (curIndex == s.length()) {
            return 1;
        }

        if(s.charAt(curIndex) == '0'){
            return 0;
        }

        if(curIndex == s.length() - 1){
            return 1;
        }

        int ans = 0;
        if(Integer.parseInt(s.substring(curIndex, curIndex+2))<=26) {
            ans = numDecodingsRecursice(s, curIndex + 2);
        }

        ans+= numDecodingsRecursice(s, curIndex+1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226123"));
    }
}
