package CrackingTheCodingInterview;

import LeetCode.ListNode;

public class DeleteMiddleNode {
    public void deleteMiddleNode(ListNode middleNode) {
        if (middleNode == null || middleNode.next == null) {
            return;
        }
        ListNode next = middleNode.next;
        middleNode.val = next.val;
        middleNode.next = next.next;

    }


}
