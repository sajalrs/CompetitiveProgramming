package Practice;

import java.util.*;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] newArr = new int[arr1.length];

        for(int num: arr1){
            if(!freq.containsKey(num)){
                freq.put(num, 1);
            } else {
                freq.put(num, freq.get(num)+1);
            }
        }

        int i=0;
        for(int num2: arr2){
            int occurrences = freq.get(num2);
            for(int j=0; j<occurrences; j++){
                newArr[i++] = num2;
            }
            freq.remove(num2);
        }

        List<Integer> remaining = new ArrayList();
        for(int rem: freq.keySet()){
            int occurrences = freq.get(rem);
            for(int j=0; j<occurrences; j++){
                remaining.add(rem);
            }
        }


        Collections.sort(remaining);
        for(int rem: remaining){
            newArr[i++] = rem;
        }
        return newArr;
    }

    public static void main(String args[]){
        RelativeSortArray relativeSortArray = new RelativeSortArray();

        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, new int[]{2,42,38,0,43,21})));
    }
}
