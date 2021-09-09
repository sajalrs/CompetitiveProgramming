package LeetCode;

public class SurroundedRegions {

    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            backtrack(board, i, 0);
            backtrack(board, i, board[0].length - 1);
        }

        for(int j=0; j<board[0].length; j++){
            backtrack(board, 0, j);
            backtrack(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void backtrack(char[][] board, int i, int j) {
        if (board[i][j] == 'X' || board[i][j] == '*') {
            return;
        } else {
            board[i][j] = '*';
            int[][] delta = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};
            for (int k = 0; k < delta.length; k++) {
                int x = i + delta[k][0];
                int y = j + delta[k][1];

                if (x >= 0 && x < board.length && y >= 0 && board.length > 0 && y < board[0].length) {
                    backtrack(board, x, y);
                }
            }

        }
    }
}
