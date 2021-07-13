package LeetCode;

public class CountTriplets {
    public int countTriples(int n) {

        int count = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                double pow = Math.pow(i,2) + Math.pow(j,2);
                int num = (int) Math.sqrt(pow);
                if(num <= n &&  Math.pow(num, 2) == pow){
                    count++;
                }

            }
        }
        return count;
    }
}
