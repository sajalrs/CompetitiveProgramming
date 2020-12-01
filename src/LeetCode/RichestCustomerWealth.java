package LeetCode;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int totalMax = 0;
        for(int[] account: accounts){
            int totalBalance = 0;
            for(int curBankBalance: account ){
                totalBalance+=curBankBalance;
            }
            totalMax = Math.max(totalMax, totalBalance);
        }
        return totalMax;
    }
}
