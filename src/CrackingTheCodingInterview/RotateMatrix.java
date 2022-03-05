package CrackingTheCodingInterview;

import java.util.Arrays;

public class RotateMatrix {
    public void rotateMatrix(int[][] matrix){
        transposeMatrix(matrix);
        swapColumns(matrix);
    }

    public void swapColumns(int[][] matrix){
        for(int i=0;i<matrix.length; i++){
            for(int j=0; j<matrix[0].length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp;
            }
        }
    }

    public void transposeMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=1; j+i<matrix.length; j++){
                int temp = matrix[i+j][i];
                matrix[i+j][i] = matrix[i][i+j];
                matrix[i][i+j] = temp;
            }
        }
    }

    public static void main(String[] args){
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };
        rotateMatrix.transposeMatrix(matrix);

        for(int[] row: matrix){
            System.out.println(Arrays.toString(row));
        }

        int[][] matrix2 = new int[][]{
                new int[]{5,1,9,11},new int[]{2,4,8,10},new int[]{13,3,6,7},new int[]{15,14,12,16}
        };

        rotateMatrix.transposeMatrix(matrix2);

        for(int[] row: matrix2){
            System.out.println(Arrays.toString(row));
        }
    }
}
