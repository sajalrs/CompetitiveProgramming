package LeetCode;

public class TotalNQueens {
    int count;
    int[][] delta = new int[][]{new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}};
    public int totalNQueens(int n) {
        count = 0;
        placeQueen(new boolean[n][n], 0);
        return count;
    }


    public void placeQueen(boolean[][] board, int row){
        if(row == board.length){
            count++;
            return;
        }

        for(int col = 0; col < board.length; col++){
            if(canPlaceQueen(board, row, col)){
                board[row][col] = true;
                placeQueen(board, row+1);
                board[row][col] = false;
            }
        }
    }

    private boolean canPlaceQueen(boolean[][] board, int i, int j){
            boolean attackedByQueen = false;
        for (int multiplier = 0; multiplier < board.length; multiplier++) {
            for (int[] dif : delta) {

                int x = i + (multiplier * dif[0]);
                int y = j + (multiplier * dif[1]);

                if (x>=0 && x < board.length && y>=0 && y < board.length) {
                    attackedByQueen = board[x][y];
                }
                if (attackedByQueen) {
                    break;
                }
            }
            if (attackedByQueen) {
                break;
            }
        }
        return !attackedByQueen;
    }


}
