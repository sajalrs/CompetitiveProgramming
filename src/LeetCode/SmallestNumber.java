package LeetCode;

import java.util.Arrays;

public class SmallestNumber {
    public long smallestNumber(long num) {
        if(num == 0l) return num;

        boolean isNegative = num < 0;
        if(isNegative){
            num*=(-1l);
        }
        int numOfDigits = 0;
        long digitCounter = num;
        while (digitCounter > 0){
            digitCounter/=10l;
            numOfDigits++;
        }
        long[] numArray = new long[numOfDigits];
        for(int i=numOfDigits-1; i>=0; i--){
           numArray[i] = num%10l;
           num/=10l;
        }
        Arrays.sort(numArray);
        long total = 0l;
        if(isNegative){
            int i=numArray.length-1;
            while(numArray[i] == 0){
                i--;
            }
            long temp = numArray[i];
            numArray[i] = numArray[numArray.length-1];
            numArray[numArray.length-1] = temp;

            for(i=numArray.length-1; i>0; i--){
                total+= numArray[i];
                total*=10l;
            }
            total+=numArray[0];
            total*=(-1l);
        } else {
            int i=0;
            while(numArray[i] == 0){
                i++;
            }

            long temp = numArray[i];
            numArray[i] = numArray[0];
            numArray[0] = temp;

            for(i=0; i<numArray.length-1; i++){
                total+= numArray[i];
                total*=10l;
            }
            total+=numArray[numArray.length-1];
        }
        return total;
    }
}
