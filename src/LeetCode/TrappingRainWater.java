package LeetCode;

public class TrappingRainWater {


    public int trap(int[] height) {


        int n = height.length;
        if(n < 3) return 0;

        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        for(int i=1;i<n; i++){
            maxLeft[i] = Math.max(height[i],maxLeft[i-1]);
        }


        int[] maxRight = new int[n];
        maxRight[n-1] = height[n-1];
        for(int i=n-2;i>=0; i--){
            maxRight[i] = Math.max(height[i],maxRight[i+1]);
        }

        int waterCollected = 0;
        for(int i=1;i<n; i++){
            waterCollected+= (Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }

        return waterCollected;
    }
}
