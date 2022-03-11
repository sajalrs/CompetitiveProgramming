package CrackingTheCodingInterview;

import LeetCode.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoopDetection {

    public ListNode loopDetection(ListNode node){
        Set<ListNode> alreadyTraversed = new HashSet<>();
        while (node != null) {
            if(alreadyTraversed.contains(node)){
                return node;
            }else {
                alreadyTraversed.add(node);
            }
            node = node.next;
        }
        return null;
    }

    public ListNode loopDetection2Runner(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        slow = slow.next;
        fast = fast.next.next;
        while (slow != null && fast != null && fast.next != null){
               if(slow == fast){
                    return getStartingNode(slow, node);
               }
               slow = slow.next;
               fast = fast.next.next;
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slow, ListNode head){
        ListNode node = head;
        while (node != null && slow != null){
            if(node == slow){
                return node;
            }
            node = node.next;
            slow = slow.next;
        }
        return null;
    }
}
