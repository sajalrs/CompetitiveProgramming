package DataStructuresAlgorithm;

import LeetCode.ListNode;


public class ReverseLinkedList {

    public ListNode reverseLinkedList(ListNode head){

        ListNode curNode = head;
        ListNode prev = null;
        ListNode next = null;

        while(curNode != null) {
            next = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = next;
        }
        return prev;

    }

}
