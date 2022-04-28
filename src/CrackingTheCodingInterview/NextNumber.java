package CrackingTheCodingInterview;

public class NextNumber {
    public void nextNumberTrivial(int num){
        int noOfOnes = countOnes(num);
        int nextBig = num + 1;
        while(countOnes(nextBig) != noOfOnes){
            nextBig++;
        }

        int nextSmall = num - 1;
        while(nextSmall > 0 && countOnes(nextSmall) != noOfOnes){
            nextSmall--;
        }

        System.out.println(nextBig);
        if(nextSmall > 0) System.out.println(nextSmall);
    }

    public void nextNumber(int num){

    }

    private int countOnes(int num){
        int count = 0;
        while (num != 0){
            if((num & 1) == 1){
                count++;
            }
            num>>=1;
        }
        return count;
    }

    public static void main(String[] args){
        NextNumber nextNumber = new NextNumber();
        nextNumber.nextNumber(2);
        nextNumber.nextNumber(15);
    }
}
