package CrackingTheCodingInterview;

import java.util.Arrays;

public class TripleStep {
    public int tripleStep(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        return tripleStepHelper(n, arr);
    }

    private int tripleStepHelper(int n, int[] arr) {
        if (n < 0) return 0;
        if (n == 0) {
            return 1;
        }
        if (arr[n] > -1) {
            return arr[n];
        }
        arr[n] = tripleStepHelper(n - 1, arr) + tripleStepHelper(n - 2, arr) + tripleStepHelper(n - 3, arr);
        return arr[n];
    }

}
