package CrackingTheCodingInterview;

import LeetCode.ListNode;

import java.util.*;

public class RemoveDups {
    public void removeDupsBuffer(ListNode head){
        ListNode prev = head;
        ListNode cur = head.next;
        Set<Integer> inList = new HashSet<>();
        while (cur != null){
            if(inList.contains(cur.val)){
                prev.next = cur.next;
            }else {
                inList.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
    }

    public void removeDupsNoBuffer(ListNode head){
        while (head != null){
            ListNode prev = head;
            ListNode check = head;
            ListNode cur = head.next;
            while (cur!=null){
                if(check.val == cur.val){
                    prev.next = cur.next;
                }
                prev = cur;
                cur = cur.next;
            }
            head = head.next;
        }
    }


}
