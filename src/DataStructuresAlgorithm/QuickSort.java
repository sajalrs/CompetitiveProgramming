package DataStructuresAlgorithm;

import java.util.Arrays;

public class QuickSort {

    static int[] arr;

    public static int partition(int left, int right){
        int pivot = arr[right];
        int origRight = right;
        right--;
        while(true){
            while(left < arr.length-1 && arr[left] < pivot ){
                left++;
            }

            while(right > 0 && arr[right] > pivot){
                right--;
            }

            if(left >= right){
                break;
            }

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        int temp = arr[left];
        arr[left] = arr[origRight];
        arr[origRight] = temp;
        return left;
    }

    public static int[] quickSort(int[] array){
        arr = array;
        quickSort(0, arr.length-1);
        return arr;
    }

    static void quickSort(int left, int right){
        if(left <= right){
            int partition = partition(left, right);
            quickSort(left, partition-1);
            quickSort(partition+1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 18, 3, 12, 0, -2};
        System.out.println(Arrays.toString(quickSort(arr)));
    }

}
