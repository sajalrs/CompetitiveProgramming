package LeetCode;

import java.util.List;

public class RemoveNthFromEnd {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode plusOne = new ListNode();
        plusOne.next = head;


        ListNode currentNthFromEnd = plusOne.next;
        ListNode prevFromCurrent = plusOne;
        ListNode toReturn = prevFromCurrent;
        ListNode currentNode = plusOne;

        for(int i= 0; i< n; i++){
            currentNode = currentNode.next;

        }

        while(currentNode.next != null){
            currentNode = currentNode.next;
            prevFromCurrent = prevFromCurrent.next;
            currentNthFromEnd = currentNthFromEnd.next;
        }

        prevFromCurrent.next = currentNthFromEnd.next;
        return toReturn.next;
    }




}
