package LeetCode;
/*
You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:

There must be exactly one ice cream base.
You can add one or more types of topping or have no toppings at all.
There are at most two of each type of topping.
You are given three inputs:

baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base flavor.
toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith topping.
target, an integer representing your target price for dessert.
You want to make a dessert with a total cost as close to target as possible.

Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.
 */
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
