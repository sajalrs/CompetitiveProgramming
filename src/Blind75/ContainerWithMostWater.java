package Blind75;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            int leftBlock = height[left];
            int rightBlock = height[right];
            int curArea = (right-left) * Math.min(leftBlock, rightBlock);
            max = Math.max(curArea, max);
            if(leftBlock == rightBlock){
                left++;
                right--;
            }else if(leftBlock > rightBlock){
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1,1}));
    }
}
