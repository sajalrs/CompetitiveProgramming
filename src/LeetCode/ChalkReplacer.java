package LeetCode;

public class ChalkReplacer {
//    public int chalkReplacer(int[] chalk, int k) {
//        while (true) {
//            for (int i = 0; i < chalk.length; i++) {
//                if (k - chalk[i] < 0) {
//                    return i;
//                }
//                k -= chalk[i];
//            }
//        }
//
//    }

    //        int totCon=0;
//        for(int i = 0; i<chalk.length; i++){
//            totCon+=chalk[i];
//        }
//
//        int[] remCon = new int[chalk.length];
//
//        for(int  j=0; j<chalk.length; j++){
//            remCon[j] = totCon - chalk[j];
//        }
//
//        for(int l=0; l<chalk.length; l++){
//            int div = k/remCon[l];
//            int deductible = (k - ((chalk[l] * (div - 1)) + (remCon[l] * div)));
//            if(deductible < 0){
//                return l;
//            }
//        }
//        return -1;


    public int chalkReplacer(int[] chalk, int k) {

        int sum = 0;
        for(int i=0; i< chalk.length; i++){
            sum+= chalk[i];
            if((k - sum) < 0) return i;
        }

        k=k%sum;
        for(int i=0; i< chalk.length; i++){
            if (k - chalk[i] < 0) {
                return i;
            }
            k -= chalk[i];
        }



        return -1;
    }
}
