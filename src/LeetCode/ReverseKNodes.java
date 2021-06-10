package LeetCode;


import java.util.List;

public class ReverseKNodes {


    public ListNode reverseKGroup(ListNode head, int k) {

        int i = 1;
        ListNode toReturn = null;
        ListNode curNode = head;
        ListNode begin = head;

        while (curNode != null) {
            if (i % k == 0) {
                ListNode cur = begin;
                ListNode prev = null;
                ListNode next = null;
                while(cur != null){
                    next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                }
                begin = curNode;
                if(i == k){
                    toReturn = begin;
                }
            }
            curNode = curNode.next;
            i++;

        }

    return toReturn;
    }

}
