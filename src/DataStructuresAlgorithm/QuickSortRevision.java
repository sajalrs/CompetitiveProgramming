package DataStructuresAlgorithm;

public class QuickSortRevision {

    public int[] QuickSort(int[] arr){
        QuickSort(arr, 0, arr.length-1);
        return arr;
    }

    private void QuickSort(int[] arr, int l, int r){
        if(l<=r){
            int pivot = partition(arr, l, r);
            QuickSort(arr, l, pivot-1);
            QuickSort(arr, pivot+1,r);
        }
    }

    private int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int origRight = r;
        r--;

        while (true){

            while (l<arr.length && arr[l] < pivot){
                l++;
            }

            while(r>0 && arr[r] > pivot){
                r--;
            }

            if(l>=r){
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        int temp = arr[origRight];
        arr[origRight] = arr[l];
        arr[l] = temp;

        return l;

    }



}
