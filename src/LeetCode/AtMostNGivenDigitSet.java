package LeetCode;

public class AtMostNGivenDigitSet {

    int numbersGreater;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        numbersGreater = 0;
        backtrack(digits, n, new StringBuilder());
        return numbersGreater - 1;
    }

    public void backtrack(String[] digits, int n, StringBuilder curNum) {
        if (curNum.length() > 0 && (curNum.length() > String.valueOf(n).length() || curNum.length() > 9 || Integer.parseInt(curNum.toString()) > n)) {
            return;
        } else {
            numbersGreater++;
            for (int i = 0; i < digits.length; i++) {
                curNum.append(digits[i]);
                backtrack(digits, n, curNum);
                curNum.deleteCharAt(curNum.length() - 1);
            }
        }

    }
}
