package Blind75;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int i=0;
        int maxProfit = 0;
        for(int j=0; j<prices.length; j++){
            maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            if(j>0 && prices[j]<prices[i]) i=j;
        }
        return maxProfit;
    }
    public static void main(String[] args){
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit.maxProfit(new int[]{7,6,4,3,1}));
    }
}
