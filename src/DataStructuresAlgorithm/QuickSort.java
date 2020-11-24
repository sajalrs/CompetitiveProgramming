package DataStructuresAlgorithm;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
        return arr;
    }

    static int partition (int[] arr, int low, int high){
        int pivot = arr[high];
        int origRight = high;
        high--;

        while(true){
            while(low< arr.length -1 && arr[low] < pivot){
                low++;
            }

            while(high>0 && arr[high] > pivot){
                high--;
            }

            if(low >= high){
                break;
            }

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        int temp = arr[origRight];
        arr[origRight] = arr[low];
        arr[low] = temp;
        return low;
    }

    static void quickSort(int arr[], int low, int high){
        if(low<=high){
            int pivot = partition(arr, low, high);
            quickSort(arr, pivot+1, high);
            quickSort(arr, low, pivot-1);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 18, 3, 12, 0, -2};
        System.out.println(Arrays.toString(quickSort(arr)));
    }

}
