package LeetCode;

public class ClosestCost {
    int result;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        result = Integer.MAX_VALUE;

        for (int baseCost : baseCosts) {
            dfs(toppingCosts, target, baseCost, 0);
        }
        return result;
    }

    public void dfs(int[] toppingCosts, int target, int total, int i) {
        if (Math.abs(target - total) < Math.abs(result - target)) {
            result = total;
        }

//        if (total > target) return;
        if (i >= toppingCosts.length) return;

        dfs(toppingCosts, target, total, i + 1);
        dfs(toppingCosts, target, total + toppingCosts[i], i + 1);
        dfs(toppingCosts, target, total + toppingCosts[i] * 2, i + 1);

    }

    public static void main(String[] args) {
        ClosestCost closestCost = new ClosestCost();
        int[] baseCosts = new int[]{2, 3};
        int[] toppingCosts = new int[]{4, 5, 100};
        System.out.println(closestCost.closestCost(baseCosts, toppingCosts, 18));
    }

}
