package LeetCode;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);

        for(int i=0; i< matrix.length; i++){
            for(int j =0; j <matrix[0].length; j++){
                heap.offer(matrix[i][j]);
                if(heap.size()>k){
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }

}
