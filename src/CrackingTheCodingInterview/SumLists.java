package CrackingTheCodingInterview;

import LeetCode.ListNode;

import javax.print.DocFlavor;

public class SumLists {
    public ListNode sumListsReversed(ListNode num1, ListNode num2) {
        ListNode cur1 = num1;
        ListNode cur2 = num2;

        int carry = 0;
        ListNode prev = null;
        ListNode head = null;
        while (cur1 != null && cur2 != null) {
            int sum = cur1.val + cur2.val + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            if (prev == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null) {
            int sum = cur1.val + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            if (prev == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            int sum = cur1.val + carry;
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            if (prev == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            cur1 = cur1.next;
        }


        return head;
    }

    private class PartialSum {
        public ListNode node;
        public int carry;

        PartialSum(ListNode node, int carry) {
            this.carry = carry;
            this.node = node;
        }
    }

    public void sumListsForward(ListNode num1, ListNode num2, PartialSum partialSum) {
        if(num1 == null && num2 == null){
            return;
        }else if(num1 != null && num2 != null){
            sumListsForward(num1.next, num2.next, partialSum);
        }
        int sum = num1.val + num2.val + partialSum.carry;
        ListNode node = new ListNode(sum % 10);
        node.next = partialSum.node;
        partialSum.node = node;
        partialSum.carry = sum/10;

    }

    private int getLength(ListNode node) {
        int count = 1;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private ListNode padList(ListNode node, int digits) {
        ListNode cur = new ListNode(0);
        for (int i = 1; i < digits; i++) {
            ListNode zero = new ListNode(0);
            cur.next = zero;
            cur = cur.next;
        }
        cur.next = node;
        return cur;
    }

    public ListNode sumListsForward(ListNode num1, ListNode num2) {
        int l1 = getLength(num1);
        int l2 = getLength(num2);

        if (l1 < l2) {
            num1 = padList(num1, l2 - l1);
        } else if (l1 > l2) {
            num2 = padList(num2, l1 - l2);
        }
        PartialSum partialSum = new PartialSum(null, 0);
        sumListsForward(num1, num2, partialSum);
        if(partialSum.carry != 0){
            ListNode node = new ListNode(partialSum.carry);
            node.next = partialSum.node;
            partialSum.node = node;
        }
        return partialSum.node;
    }

}
