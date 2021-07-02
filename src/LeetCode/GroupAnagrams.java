package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){

            char[] alphabetizedStringArr = str.toCharArray();
            mergeSort(0, alphabetizedStringArr.length-1, alphabetizedStringArr);

            String alphabetizedString = new String(alphabetizedStringArr);

            if(map.containsKey(alphabetizedString)){

                map.get(alphabetizedString).add(str);
            }else {

                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(alphabetizedString, list);
            }
        }

        List<List<String>> toReturn = new ArrayList<>();
        for(List<String> listOfStrings: map.values()){
            toReturn.add(listOfStrings);
        }
        return toReturn;
    }

    public void merge(int l, int m, int r, char[] arr){

        int n1 = m - l + 1;
        int n2 = r - m ;

        char[] arrL = new char[n1];
        char[] arrR = new char[n2];

        for(int i=0; i< n1; i++){
            arrL[i] = arr[l+i];
        }

        for(int i=0; i< n2; i++){
            arrR[i] = arr[m + i + 1];
        }

        int i=0;
        int j=0;
        int k=l;

        while(i<n1 && j<n2){
            if(arrL[i] < (arrR[j])){
                arr[k] = arrL[i];
                i++;
            } else {
                arr[k] = arrR[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = arrL[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = arrR[j];
            j++;
            k++;
        }

    }

    public void mergeSort(int l, int r, char[] arr){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(l, m, arr);
            mergeSort(m+1,r, arr);
            merge(l,m,r,arr);
        }
    }



}
