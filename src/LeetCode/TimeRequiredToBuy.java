package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class TimeRequiredToBuy {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<tickets.length; i++){
            queue.add(i);
          }

        int timeTaken = 0;
        while (!queue.isEmpty()){
            timeTaken++;
            int curCustomer = queue.poll();
            tickets[curCustomer]--;
            if(tickets[curCustomer] == 0){
                if(curCustomer == k) return timeTaken;
            }else{
                queue.add(curCustomer);
            }
        }
        return timeTaken;
    }
}
