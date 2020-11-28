package DataStructuresAlgorithm;

import java.util.Arrays;

public class AllSorts {

    public static int[] insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int j = i;
            while(j>0 && arr[j-1] > arr[j]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr){
        for(int i = 0; i<arr.length; i++){
            int min = i;
            for(int j =i; j<arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int origHigh = high;
        high--;
        while(true){
            while(low< arr.length-1 && arr[low] < pivot){
                low++;
            }

            while(high>0 && arr[high] > pivot){
                high--;
            }

            if(low>=high){
                break;
            }

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        int temp = arr[low];
        arr[low] = arr[origHigh];
        arr[origHigh] = temp;

        return low;
    }

    public static int[] quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low<=high){
           int partition = partition(arr, low, high);
           quickSort(arr, low, partition-1);
           quickSort(arr, partition+1, high);
        }
    }

    private static void merge(int[] arr, int l, int m, int r){
        int n1 = m + 1 - l;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i =0; i<n1; i++){
            L[i] = arr[l+i];
        }

        for(int j=0; j<n2; j++){
            R[j] = arr[m+1+j];
        }

        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int[] mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
        return arr;
    }

    private static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 7, 51, -6};
        System.out.println(Arrays.toString(mergeSort(arr)));
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(quickSort(arr)));
        int[] arr2 = {-2, 0, 12, 3, 18, 1};
        System.out.println(Arrays.toString(mergeSort(arr2)));
        System.out.println(Arrays.toString(insertionSort(arr2)));
        System.out.println(Arrays.toString(bubbleSort(arr2)));
        System.out.println(Arrays.toString(selectionSort(arr2)));
        System.out.println(Arrays.toString(quickSort(arr2)));

    }


}
