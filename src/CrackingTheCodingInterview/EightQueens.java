package CrackingTheCodingInterview;

import java.util.ArrayList;

public class EightQueens {
    public void eightQueens() {

        eightQueensHelper(new boolean[4][4],  0);
    }

    public void eightQueensHelper(boolean[][] board, int row) {
        if(row == board.length){
            for(boolean[] boardRow: board){
                for(boolean hasQueen: boardRow){
                    if(hasQueen){
                        System.out.print(" X ");
                    }else {
                        System.out.print(" O ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int col=0; col<board.length; col++){
            if(canPlaceQueen(board, row, col)){
                board[row][col] = true;
                eightQueensHelper(board, row+1);
                board[row][col] = false;
            }
        }
    }

    public boolean canPlaceQueen(boolean[][] board, int row, int col){
        int[][] deltas = new int[][]{new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}};
        boolean cantPlace = false;
        for (int[] delta : deltas) {
            if(cantPlace) break;
            for (int i = 1; i < board[0].length && !cantPlace; i++) {
                int newX = i * delta[0] + row;
                if (newX<0 || newX >= board[0].length) break;
                int newY = i * delta[1] + col;
                if (newY<0 || newY >= board.length) break;
                if(board[newX][newY]) cantPlace = true;
            }
        }
        return !cantPlace;
    }

    int GRID_SIZE = 8;

    void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if(row == GRID_SIZE){
            results.add(columns.clone());
        }else{
            for(int i=0; i<GRID_SIZE; i++){
                columns[row] = i;
                placeQueens(row+1, columns, results);
            }
        }

    }

    boolean checkValid(Integer[] columns, int row1, int column1){
        for(int row2=0; row2<row1; row2++){
            int column2 = columns[row2];
            if(column1 == column2){
                return false;
            }

            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2;
            if(columnDistance == rowDistance) return false;

        }
        return true;
    }

    public static void main(String[] args){
        EightQueens eightQueens = new EightQueens();
        eightQueens.eightQueens();
    }
}
