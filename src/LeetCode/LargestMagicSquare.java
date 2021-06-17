package LeetCode;

public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        
        int[][] cumRowSum = new int[M][N];
        int[][] cumColSum = new int[M][N];
        int[][] cumDiagSum = new int[M][N];
        int[][] cumAntiDiagSum = new int[M][N];

        for(int i=0; i< M; i++){
            for(int j=0; j<N; j++){
                if (j > 0) {
                    cumRowSum[i][j] = cumRowSum[i][j - 1] + grid[i][j];
                } else {
                    cumRowSum[i][j] = grid[i][j];
                }
                if (i > 0) {
                    cumColSum[i][j] = cumColSum[i - 1][j] + grid[i][j];
                } else {
                    cumColSum[i][j] = grid[i][j];
                }
                if (j > 0 && i > 0) {
                    cumDiagSum[i][j] = cumDiagSum[i - 1][j - 1] + grid[i][j];
                } else {
                    cumDiagSum[i][j] = grid[i][j];
                }
                if (i > 0 && j < grid[0].length - 1) {
                    cumAntiDiagSum[i][j] = cumAntiDiagSum[i - 1][j + 1] + grid[i][j];
                } else {
                    cumAntiDiagSum[i][j] = grid[i][j];
                }
            }
        }

        int max = 1;
        for(int size = 2; size<= Math.min(M,N); size++) {
            for(int i=0; i< M; i++){
                for(int j =0; j< N; j++){

                    if(i-size+1>=0 && j-size+1>=0){

                        int iStart = i-size+1;
                        int jStart = j-size+1;

                        int rowSum = (cumRowSum[i][j] - cumRowSum[i][jStart]) + grid[i][jStart] ;
                        int colSum = (cumColSum[i][j] - cumColSum[iStart][j]) + grid[iStart][j];

                        if(rowSum != colSum){
                            continue;
                        }

                        boolean isEqual = true;
                        for(int k = iStart; k< i && isEqual; k++){
                            int curRowSum = (cumRowSum[k][j] - cumRowSum[k][jStart]) + grid[k][jStart] ;
                            if(curRowSum != rowSum){
                                isEqual = false;
                                break;
                            }
                        }

                        for(int k = jStart; k< j && isEqual; k++){
                            int curColSum = (cumColSum[i][k] - cumColSum[iStart][k]) + grid[iStart][k];
                            if(curColSum != colSum){
                                isEqual = false;
                                break;
                            }
                        }

                        if(!isEqual){
                            continue;
                        }

                        int diagSum = (cumDiagSum[i][j] - cumDiagSum[iStart][jStart]) + grid[iStart][jStart];
                        if(colSum != diagSum){
                            continue;
                        }

                        int antiDiagSum = (cumAntiDiagSum[i][jStart] - cumAntiDiagSum[iStart][j]) + grid[iStart][j] ;
                        if(antiDiagSum != diagSum){
                            continue;
                        }

                        max = Math.max(size,max);
                    }
                }
            }
        }


        
        return max;

    }
}
