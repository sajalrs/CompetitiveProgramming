package CrackingTheCodingInterview;

import Utility.TreeNode;

public class CheckBalanced {
    private class HeightBalance {
        int height = 0;
        boolean isBalanced = true;

        HeightBalance(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean checkBalanced(TreeNode root) {
        return calculateHeight(root).isBalanced;
    }

    private HeightBalance calculateHeight(TreeNode node) {
        if (node == null) {
            return new HeightBalance(0, true);
        }

        HeightBalance heightBalanceLeft = calculateHeight(node.left);
        HeightBalance heightBalanceRight = calculateHeight(node.right);

        if (!heightBalanceLeft.isBalanced || !heightBalanceRight.isBalanced) return new HeightBalance(0, false);

        int heightUnder = Math.max(heightBalanceLeft.height, heightBalanceRight.height);
        boolean isBalanced = Math.abs(heightBalanceLeft.height - heightBalanceRight.height) <= 1;

        return new HeightBalance(1 + heightUnder, isBalanced);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public boolean checkBalancedN2(TreeNode root) {
        if (root == null) return true;

        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        if (heightDiff > 1) {
            return false;
        } else {
            return checkBalancedN2(root.left) && checkBalancedN2(root.right);
        }
    }
}
