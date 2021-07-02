package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {


    public String getPermutation(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            stringBuilder.append(i);
        }
        List<Integer> list = new LinkedList<>();
        permute(stringBuilder, 0, n, k, list);
        Collections.sort(list);
        return String.valueOf(list.get(k - 1));

    }

    private void permute(StringBuilder stringBuilder, int l, int r, int k, List<Integer> list) {
        if (l == r) {

            int num = Integer.parseInt(stringBuilder.toString());

            list.add(num);


        } else {
            for (int i = l; i < r; i++) {
                swap(stringBuilder, i, l);
                permute(stringBuilder, l + 1, r, k, list);
                swap(stringBuilder, i, l);
            }
        }
    }


    private void swap(StringBuilder stringBuilder, int i, int j) {
        char temp = stringBuilder.charAt(i);
        stringBuilder.setCharAt(i, stringBuilder.charAt(j));
        stringBuilder.setCharAt(j, temp);
    }


}
