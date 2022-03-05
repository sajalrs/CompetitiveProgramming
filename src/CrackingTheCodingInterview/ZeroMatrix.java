package CrackingTheCodingInterview;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public void zeroMatrix(int[][] matrix){
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
            for(int j=0; j<matrix[row].length; j++){
                matrix[row][j] = 0;
            }
        }


        for(int col: columns){
            for(int i=0; i<matrix.length; i++){
                matrix[i][col] = 0;
            }
        }
    }

}
