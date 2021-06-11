package LeetCode;


import java.util.List;

public class ReverseKNodes {


    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode root = new ListNode(0, head);
        ListNode curNode = head;
        ListNode prev = root;

        while (curNode != null) {
            ListNode tail = curNode;
            int i = 0;

            while (curNode != null && i < k) {

                curNode = curNode.next;
                i++;
            }

            if (i != k) {
                prev.next = tail;
            } else {
                prev.next = reverse(tail, k);
                prev = tail;
            }


        }

        return root.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        while (cur != null && k-- > 0) {

            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }

        return prev;
    }


}
