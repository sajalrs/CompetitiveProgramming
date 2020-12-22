package LeetCode;

public class MaxStonks {
    public static int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;

        int min = prices[0];
        int max = prices[0];
        int globalProfits= 0;
        for(int i=1; i<prices.length;i++){
            int curPrice = prices[i];
            if(curPrice < min){
                globalProfits = Math.max(max - min, globalProfits);
                min = curPrice;
                max = curPrice;
            } else {
                max = Math.max(curPrice, max);
            }

        }


        return globalProfits = Math.max(max - min, globalProfits);
    }

    public static void main(String[] args){
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(array));
        int[] array2 = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(array2));
        int[] array3 = new int[]{2,4, 1};
        System.out.println(maxProfit(array3));

    }
}
