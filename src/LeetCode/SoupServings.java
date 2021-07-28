package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SoupServings {

    public double soupServings(int n) {
        if(n > 4800) return 1;
        Map<Integer, Map<Integer, Double>> memo = new HashMap<>();
        return serveSoup(n, n, memo);
    }

    private double serveSoup(int A, int B, Map<Integer, Map<Integer, Double>> memo) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        } else if (A <= 0) {
            return 1;
        } else if (B <= 0) {
            return 0;
        } else {
            if (!memo.containsKey(A) || !memo.get(A).containsKey(B)) {
                double opt1 = serveSoup(A - 100, B, memo);
                double opt2 = serveSoup(A - 75, B-25, memo);
                double opt3 = serveSoup(A - 50, B - 50, memo);
                double opt4 = serveSoup(A - 25, B - 75, memo);

                if(!memo.containsKey(A)){
                    memo.put(A, new HashMap<>());
                }
                memo.get(A).put(B, 0.25 * (opt1 + opt2 + opt3 + opt4));
            }
            return memo.get(A).get(B);
        }
    }
}
