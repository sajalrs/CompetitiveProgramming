package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);

        int curSize =0;
        for(int[] boxType: boxTypes){
            int boxCount = Math.min(boxType[0], truckSize);
            truckSize-=boxCount;
            curSize+=  boxCount*boxType[1];
            if(truckSize == 0) break;

        }
         return curSize;
    }

    public static void main(String[] args){
        MaximumUnits maximumUnits = new MaximumUnits();
        System.out.println(maximumUnits.maximumUnits(new int[][]{new int[]{1,3},new int[]{2,2},new int[]{3,1}}, 4));
    }
}
