package LeetCode;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        mergeSort(0, nums.length-1, nums);
        return nums[nums.length-k];
    }

    private void mergeSort(int l, int r, int[] arr){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(l,m, arr);
            mergeSort(m+1, r, arr);
            merge(l,m,r,arr);
        }
    }

    private void merge(int l, int m, int r, int[] arr){
        int n1 = m+1-l;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0; i< n1; i++){
            L[i] = arr[l+i];
        }

        for(int j=0; j<n2; j++){
            R[j] = arr[m+1+j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i<n1 && j < n2){
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
}
