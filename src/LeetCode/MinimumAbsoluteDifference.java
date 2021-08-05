package LeetCode;

import java.util.*;


public class MinimumAbsoluteDifference {

    int minDif;
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        minDif = Integer.MAX_VALUE;

        mergeSort(arr, 0, arr.length-1);

        List<List<Integer>> listWithMinAbsDiff = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i] + minDif, arr[i]);
        }

        for(int i = 0; i<arr.length; i++){
           if(map.containsKey(arr[i])){
               List<Integer> numsWithDif = new ArrayList<>();
               numsWithDif.add(map.get(arr[i]));
               numsWithDif.add(arr[i]);
               listWithMinAbsDiff.add(numsWithDif);
           }
        }

        return listWithMinAbsDiff;

    }

    private void merge(int[] arr, int l, int m, int r){

        int n1 = m - l  + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i< n1; i++){
            L[i] = arr[l + i];
        }

        for(int j = 0; j < n2; j++){
            R[j] = arr[m + j + 1];
        }

        int k = l;
        int i = 0;
        int j = 0;

        int prevNum = Math.min(L[0], R[0]);
        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            int dif = arr[k] - prevNum;
            if(dif != 0 && dif < minDif){
                minDif = dif;
            }
            prevNum = arr[k];
            k++;
        }

        while(i<n1){
            arr[k] = L[i];
            int dif = arr[k] - prevNum;
            if(dif != 0 && dif < minDif){
                minDif = dif;
            }
            prevNum = arr[k];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = R[j];
            int dif = arr[k] - prevNum;
            if(dif != 0 && dif < minDif){
                minDif = dif;
            }
            prevNum = arr[k];
            j++;
            k++;
        }

    }

    private void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }


}
