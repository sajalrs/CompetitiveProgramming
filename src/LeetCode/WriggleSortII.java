package LeetCode;

import java.util.PriorityQueue;

public class WriggleSortII {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<nums.length; i++){
            maxHeap.add(nums[i]);
        }

        for(int i=0; i<nums.length;i++){
            if(i%2!=0){
                nums[i] = maxHeap.poll();
            }
        }


        for(int i=0; i<nums.length;i++){
            if(i%2==0){
                nums[i] = maxHeap.poll();
            }
        }
    }
}
