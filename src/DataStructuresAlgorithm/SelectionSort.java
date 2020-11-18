package DataStructuresAlgorithm;

public class SelectionSort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 0, -2};
        for (int num : sort(arr)) {
            System.out.println(num);
        }
    }
}

