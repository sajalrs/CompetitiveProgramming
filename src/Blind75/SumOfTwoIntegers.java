package Blind75;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {

        int num = 0;
        int i = 1;
        boolean prev = false;
        while (a != 0 || b != 0) {
            int curBitA = (a & 1);
            int curBitB = (b&1);

            if ((curBitA== 1) && (curBitB == 1)) {
                if(prev) num = num | ( i );
                prev = true;
            } else if ((curBitA == 0) && (curBitB == 0)) {
                if (prev) num = num | (i);
                prev = false;
            } else {
                if(!prev) num = num | ( i );
            }
            i<<=1;
            a >>= 1;
            b >>= 1;
        }

        if(prev) num = num | (i);
        return num;
    }

    public static void main(String[] args){
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        System.out.println(sumOfTwoIntegers.getSum(1,2));
        System.out.println(sumOfTwoIntegers.getSum(2,3));
        System.out.println(sumOfTwoIntegers.getSum(12,30));
    }

}
