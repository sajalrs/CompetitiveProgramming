package LeetCode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {

        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        memo[0][0] = true;
        isMatchHelper(s, p, memo);
        return memo[s.length()][p.length()];
    }

    public void isMatchHelper(String s, String p, boolean[][] memo) {


        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length ; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    memo[i][j] = memo[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    memo[i][j] = memo[i-1][j - 1] || memo[i - 1][j];
                } else {
                    memo[i][j] = false;
                }
            }
        }


    }
}
