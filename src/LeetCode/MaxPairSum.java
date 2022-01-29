package LeetCode;

public class MaxPairSum {
    public int pairSum(ListNode head) {
        ListNode cur;
        cur = head;
        int size = 0;
        while(cur!=null){
            cur = cur.next;
            size++;
        }
       cur = head;

        int[] sum = new int[size/2];
        int index = 0;
        while(cur!=null){
            if(index <= (size/2 - 1)){
                sum[index]+= cur.val;
            }else {
                sum[size - 1 - index]+= cur.val;
            }
            cur = cur.next;
            index++;
        }

        int max = sum[0];
        for(int num :sum){
            max = Math.max(num, max);
        }
        return max;
    }
}
