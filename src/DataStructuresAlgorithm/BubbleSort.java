package DataStructuresAlgorithm;

public class BubbleSort {
    public static int[] sort(int[] arr){
        for(int i=1; i< arr.length; i++){
            for(int j = 0; j< arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }

        return arr;
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 12, 0, -2};
        for (int num : sort(arr)) {
            System.out.println(num);
        }
    }

}
