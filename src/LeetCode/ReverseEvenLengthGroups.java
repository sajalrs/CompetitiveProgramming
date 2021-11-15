package LeetCode;

public class ReverseEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int i = 0;
        while (cur!=null){
            i++;
            int j = 0;
            ListNode temp = prev;
            while(j < i && cur != null){
                prev = cur;
                cur = cur.next;
                j++;
            }

            if(j% 2 == 0){
                prev = temp.next;
                temp.next = reverse(temp.next, i);
                prev.next = cur;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode cur, int k) {
        int count = 0;
        ListNode prev = null;
        ListNode next = null;

        while (cur != null && count < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        return prev;
    }


}
