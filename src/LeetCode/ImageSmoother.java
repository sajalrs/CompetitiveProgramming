package LeetCode;


public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {


        int[][] delta = new int[][]{new int[]{0,0}, new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1},
                new int[]{0, -1}, new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}};

        int[][] smoothedImage = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int noOfCells = 0;
                int sum = 0;
                for (int k = 0; k < delta.length; k++) {

                    int xPos = delta[k][0] + i;
                    int yPos = delta[k][1] + j;

                    if (xPos >= 0 && xPos < img.length && yPos >= 0 && yPos < img[i].length) {
                        noOfCells++;
                        sum+= img[xPos][yPos];
                    }
                }
                smoothedImage[i][j] = Math.floorDiv(sum,noOfCells);
            }
        }

        return smoothedImage;
    }
}
