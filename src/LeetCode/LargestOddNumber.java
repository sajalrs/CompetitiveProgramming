package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LargestOddNumber {

    public void largestOddNumber(String num) {
        List<Integer> allCombos = new ArrayList<>();
        StringBuilder curNum = new StringBuilder();
        genAllCombinations(num, 0, curNum, allCombos);

        for (int number : allCombos) {
            System.out.println(number);
        }
    }

    public void genAllCombinations(String num, int index, StringBuilder curNum, List<Integer> allCombos) {
        if (index >= num.length()) {
            String generatedNumString = curNum.toString();
            if(!generatedNumString.equals("")){
                allCombos.add(Integer.parseInt(generatedNumString));
            }
            return;
        }

        for (int i = 0; i < num.length(); i++) {
            if (index > i) {
                StringBuilder numString = new StringBuilder(curNum);
                numString.append(num.charAt(i));
                genAllCombinations(num, index + 1, numString, allCombos);
            } else {
                genAllCombinations(num, index + 1, curNum, allCombos);
            }
        }

    }

    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        largestOddNumber.largestOddNumber("52");
    }
}
