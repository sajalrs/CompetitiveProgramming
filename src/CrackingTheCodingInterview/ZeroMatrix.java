package CrackingTheCodingInterview;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public void zeroMatrixN(int[][] matrix){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();

        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                int curNum = matrix[i][j];
                if(curNum == 0){
                    columns.add(i);
                    rows.add(j);
                    break;
                }
            }
        }

        for(int row: rows){
            nullifyRow(matrix, row);
        }


        for(int col: columns){
            nullifyCol(matrix,col);
        }
    }

    public void zeroMatrix(int[][] matrix){
        zeroMatrixInplace(matrix);
    }

    public void zeroMatrixInplace(int[][] matrix){
        for(int i =1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                int curNum = matrix[i][j];
                if(curNum == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    break;
                }
            }
        }

        for(int j=0; j<matrix.length; j++){
            if(matrix[0][j] == 0) nullifyCol(matrix, j);
        }


        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0) nullifyRow(matrix, i);
        }


    }

    private void nullifyRow(int[][] matrix, int row){
        for(int j=0; j<matrix[row].length; j++){
            matrix[row][j] = 0;
        }
    }

    private void nullifyCol(int[][] matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

}
