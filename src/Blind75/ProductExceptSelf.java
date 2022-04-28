package Blind75;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length+2];
        int[] right = new int[nums.length+2];
        left[0] = 1;
        right[0] = 1;
        left[nums.length+1] = 1;
        right[nums.length+1] = 1;

        for(int i=0; i<nums.length; i++){
            left[i+1] = left[i] * nums[i];
        }

        for(int j=nums.length -1; j>= 0; j--) {
            right[j+1] = right[j+2] * nums[j];
        }

        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]  = left[i] * right[i+2];
        }
        return arr;
    }

    public static void main(String[] args){
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        for(int num: productExceptSelf.productExceptSelf(new int[]{-1,1,0,-3,3})){
            System.out.println(num);
        }
    }
}
