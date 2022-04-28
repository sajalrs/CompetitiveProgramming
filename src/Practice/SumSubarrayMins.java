package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumSubarrayMins {
    private class Number implements Comparable<Number> {
        int value;
        int index;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }


        @Override
        public int compareTo(Number number) {
            return Integer.compare(this.value, number.value);
        }
    }

    public int sumSubarrayMinsN2(int[] arr) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            numbers.add(new Number(i, arr[i]));
        }
        Collections.sort(numbers);

        int m = (int)(1e9 + 7);
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i < 0 || i >= arr.length) continue;
                int k = -1;
                int numIndex;
                do{
                    numIndex = numbers.get(++k).index;
                }while (numIndex < i || numIndex > j);
                int min = numbers.get(k).value;
                total+=min;
                total%=m;
            }
        }
        return total;
    }




    public void generateSubarray(int[] arr, List<int[]> subArrays){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                int[] newArr = new int[j-i+1];
                int l=0;
                for(int k=i; k<=j; k++){
                    newArr[l++] = arr[k];
                }
                subArrays.add(newArr);
            }
        }
    }

    public static void main(String[] args){
        SumSubarrayMins sumSubarrayMins = new SumSubarrayMins();
        List<int[]> list = new ArrayList<>();
      sumSubarrayMins.generateSubarray(new int[]{3,1,2,4}, list);
      for(int[] arr: list){
          System.out.println(Arrays.toString(arr));
      }

    }
}
