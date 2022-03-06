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
        ListNode cur = head.next;
        while (cur != null){
            ListNode newPointer = cur.next;
            ListNode prev = head;
            while (newPointer != null){
                if(newPointer.val == cur.val){
                    prev.next = newPointer.next;
                }else {
                    prev = newPointer;
                }
                newPointer = newPointer.next;
            }
            cur = cur.next;
        }
    }


}
