package LeetCode;

import java.util.Map;
import java.util.TreeMap;

public class HappyNumber {

    static boolean isHappy(int n, Map<Integer, Boolean> alreadyExists){
        int sum = 0;
        while(n>0){
            int curDigit = n%10;
            sum+= Math.pow(curDigit, 2);
            n = n/10;
        }
        if(sum == 1){
            return true;
        } else if(alreadyExists.containsKey(sum)) {
                return false;
        } else {
            alreadyExists.put(sum, true);
            return isHappy(sum, alreadyExists);
        }

    }

    static boolean isHappy(int n){
        Map<Integer, Boolean> alreadyExists = new TreeMap<>();
        return isHappy(n, alreadyExists);
    }
    public static void main(String[] args){

        System.out.println(isHappy(2));
    }
}
