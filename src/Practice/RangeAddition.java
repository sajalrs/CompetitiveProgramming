package Practice;

import java.util.Arrays;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            for (int k = i; k <= j; k++) {
                arr[k] += update[2];
            }
        }
        return arr;
    }



    public static void main(String[] args) {
        RangeAddition rangeAddition = new RangeAddition();
        System.out.println(Arrays.toString(rangeAddition.getModifiedArray(5, new int[][]{new int[]{1, 3, 2}, new int[]{2, 4, 3}, new int[]{0, 2, -2}})));
        System.out.println(Arrays.toString(rangeAddition.getModifiedArray(10, new int[][]{new int[]{2,4,6}, new int[]{5,6,8}, new int[]{1,9,-4}})));
    }
}
