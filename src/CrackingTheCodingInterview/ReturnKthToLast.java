package CrackingTheCodingInterview;

import LeetCode.ListNode;

public class ReturnKthToLast {
    public ListNode returnKthToLast(ListNode head, int k){
        ListNode cur = head;
        for (int i=0; i<=k; i++){
            head = head.next;
        }

        while (head!=null){
            head = head.next;
            cur = cur.next;
        }

        return cur;
    }

    public ListNode returnKthToLastLengthKnown(ListNode head, int k){
        ListNode cur = head;

        int count = 0;
        while(cur != null){
            count++;
            cur = cur.next;
        }

        for(int i=1; i<count-k; i++){
            head = head.next;
        }
        return head;
    }

    public int returnKthToLastRecursivePrint(ListNode head, int k){
        if(head == null){
            return -1;
        }

        int index = returnKthToLastRecursivePrint(head.next, k) + 1;
        if(index == k){
            System.out.println(head.val);
        }
        return index;
    }

    private class Wrapper{
        int index;
        ListNode node;
        public Wrapper(int index, ListNode node){
            this.index = index;
            this.node = node;
        }
    }

    public ListNode returnKthToLastRecursive(ListNode head, int k){
        return returnKthToLastRecursiveWrapper(head,k).node;
    }

    public Wrapper returnKthToLastRecursiveWrapper(ListNode head, int k){
        if(head == null){
            return new Wrapper(-1, null);
        }

        Wrapper wrapper = returnKthToLastRecursiveWrapper(head.next, k);
        int index = wrapper.index + 1;
        wrapper.index = index;
        if(index == k){
            wrapper.node = head;
        }
        return wrapper;
    }



}
