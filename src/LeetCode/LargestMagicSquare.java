package LeetCode;

public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {

        int[][] rowSum = new int[grid.length + 2][grid[0].length+2];
        int[][] colSum = new int[grid.length + 2][grid[0].length+2];
        int[][] diagSum = new int[grid.length + 2][grid[0].length+2];
        int[][] antiDiagSum = new int[grid.length + 2][grid[0].length+2];

        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                rowSum[i+1][j+1] = rowSum[i+1][j] + grid[i][j];
                colSum[i+1][j+1] = colSum[i][j+1] + grid[i][j];
                diagSum[i+1][j+1] = diagSum[i][j] + grid[i][j];
                antiDiagSum[i+1][j+1] = antiDiagSum[i][j+2] + grid[i][j];
            }
        }

        int max = 1;
        for(int i=2; i< Math.min(grid.length, grid[0].length); i++){
            for(int j= 1; j < grid.length-1; j++){
                for(int k=1; k<grid[0].length-1; k++){





                }
            }
        }


        System.out.println("Row Sum");
        printInnerSquares(rowSum);
        System.out.println("Col Sum");
        printInnerSquares(colSum);
        System.out.println("Diagonal Sum");
        printInnerSquares(diagSum);
        System.out.println("Anti Diagonal Sum");
        printInnerSquares(antiDiagSum);

        return 0;
    }

    public void printInnerSquares(int[][] grid){
        for(int i= 1; i < grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
    }

}
