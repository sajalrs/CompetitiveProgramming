package LeetCode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {

        boolean[][] isMatchMemo = new boolean[s.length()+1][p.length()+1];

        isMatchMemo[0][0] = true;
        for(int i = 1; i < isMatchMemo[0].length; i++){
            isMatchMemo[0][i] = isMatchMemo[0][i-1] && (p.charAt(i-1) == '*');
        }

        for(int j = 1; j < isMatchMemo.length; j++){
            isMatchMemo[j][0] = false;
        }

        for(int i=1; i< isMatchMemo.length; i++){
            for(int j=1; j< isMatchMemo[0].length; j++){
               char charString = s.charAt(i-1);
               char charPattern = p.charAt(j-1);

               if(charPattern == '?' || charPattern == charString){
                   isMatchMemo[i][j] = isMatchMemo[i-1][j-1];
               } else if(charPattern == '*'){
                   isMatchMemo[i][j] = isMatchMemo[i-1][j] || isMatchMemo[i][j-1];;
               } else {
                   isMatchMemo[i][j] = false;
               }
            }
        }

        return isMatchMemo[isMatchMemo.length-1][isMatchMemo[0].length-1];
    }





}
