package CrackingTheCodingInterview;

import LeetCode.ListNode;

import java.util.Arrays;

public class Partition {
    public ListNode partition(ListNode head, int x){

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy.next;

        int count = 0;
        while (cur!=null){
            count++;
            prev = cur;
            cur = cur.next;
        }

        ListNode tail = prev;
        prev = dummy;
        cur = head;
        for(int i=0; i<count; i++){
            if(cur.val > x){
                prev.next = cur.next;
                tail.next = cur;
                ListNode temp = cur;
                cur = cur.next;
                temp.next = null;
                tail = temp;
            } else if(cur.val < x){
                prev.next = cur.next;
                ListNode temp = cur.next;
                cur.next = dummy.next;
                dummy.next = cur;
                cur = temp;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public ListNode partitionTwoLists(ListNode head, int x){
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (head != null){
            ListNode next = head.next;
            head.next = null;
            if(head.val < x){
                if(beforeStart == null){
                    beforeStart = head;
                    beforeEnd = head;
                }else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }

            }else if(head.val > x){
                if(afterStart == null){
                    afterStart = head;
                    afterEnd = head;
                }else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }else {
                if(afterStart == null){
                    afterStart = head;
                    afterEnd = head;
                }else {
                    head.next = afterStart;
                    afterStart = head;
                }
            }
            head = next;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
