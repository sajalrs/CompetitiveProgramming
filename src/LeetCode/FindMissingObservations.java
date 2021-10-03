package LeetCode;

import java.util.Arrays;

public class FindMissingObservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int Sm = findSm(rolls, mean, n);
        int initialValue = Sm / n;
        int remaining = Sm % n;
        if (initialValue > 6 || initialValue <= 0 || (initialValue == 6 && remaining != 0)) return new int[]{};
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            missing[i] = initialValue;
        }


        for (int i = 0; i < n && remaining > 0; i++) {
            int curValue = missing[i];
            int toInsert = Math.min(6, remaining + curValue);
            missing[i] = toInsert;
            remaining -= (toInsert - curValue);
        }


        return missing;
    }

    public int findSm(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        return (mean * (rolls.length + n) - sum);
    }
}
