package LeetCode;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] occupiedHorizontal = new boolean[9][10];
        boolean[][] occupiedVertical = new boolean[9][10];
        boolean[][] occupiedBox = new boolean[9][10];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char curChar = board[i][j];
                if(curChar != '.'){
                    int curNum = Integer.parseInt(String.valueOf(curChar));
                    int boxNumber = 3*(i/3) + (j/3);
                    boolean isOccupiedHorizontal = occupiedHorizontal[i][curNum];
                    boolean isOccupiedVertical = occupiedVertical[j][curNum];
                    boolean isOccupiedBox = occupiedBox[boxNumber][curNum];
                    if(isOccupiedHorizontal || isOccupiedVertical || isOccupiedBox){
                        return false;
                    }
                occupiedHorizontal[i][curNum] = true;
                occupiedVertical[j][curNum] = true;
                 occupiedBox[boxNumber][curNum] = true;

                }
            }
        }

        return true;

    }

}
