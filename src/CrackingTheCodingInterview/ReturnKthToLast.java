package CrackingTheCodingInterview;

import LeetCode.ListNode;

public class ReturnKthToLast {
    public ListNode returnKthToLast(ListNode head, int k){
        ListNode cur = head;
        for (int i=0; i<k; i++){
            head = head.next;
        }

        while (head!=null){
            head = head.next;
            cur = cur.next;
        }

        return cur;
    }
}
