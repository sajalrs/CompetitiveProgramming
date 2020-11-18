package DataStructuresAlgorithm;

public class InsertionSort {
    /*
        Strategy: Divide into sorted and unsorted
        Pick first from unsorted. Compare this item
        with max in sorted and keep moving left
        (swapping) while item to the left is greater
        than the picked item. Repeat for all items
        in list and voila (Hoping exclamations improve
        memory. Also chewing gum rn) you have sorted
        array.
     */
    public static int[] sort(int[] arr) {
        /*Go through the array. Starts from 1 because
          assumed sorted till 1.
        * */
        for (int i = 1; i < arr.length; i++) {
            //Pick first from unsorted
            int j = i;
            //Start from last in unsorted which
            //is just item right before arr[j]
            //Keep swapping if item before is
            //greater
            while (j > 0 && arr[j - 1] > arr[j]) {
                //Here's where the swaps are happening
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                //Nothing to see here. Keep it moving
                j -= 1;
            }
        }

        return arr; //Ahoy me matey
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 12, 0, -2};
        for (int num : sort(arr)) {
            System.out.println(num);
        }
        //Success. Now do it on a piece of paper
        //like a heathen
    }

}
