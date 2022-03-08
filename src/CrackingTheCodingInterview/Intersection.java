package CrackingTheCodingInterview;

import LeetCode.ListNode;

public class Intersection {
    public ListNode intersectionN2(ListNode node1, ListNode node2){
        ListNode cur = node2;
        while (node1 != null){
            node2 = cur;
            while (node2 != null){
                if(node1 == node2) return node1;
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        return null;
    }

    private class Result{
        int length;
        ListNode tail;
        public Result(int length, ListNode tail){
            this.length = length;
            this.tail = tail;
        }
    }

    public ListNode intersection(ListNode node1, ListNode node2){

        Result result1 = getTailAndLength(node1);
        Result result2 = getTailAndLength(node2);

        if(result1.tail != result2.tail){
            return null;
        }
        ListNode longer;
        ListNode shorter;
        int maxLength;
        if(result1.length > result2.length){
            longer = node1;
            shorter = node2;
            maxLength = result1.length;
        } else {
            longer = node2;
            shorter = node1;
            maxLength = result2.length;
        }


        for(int i=0; i< maxLength - Math.min(result1.length, result2.length);i++){
            longer = longer.next;
        }

        while (shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }

    public Result getTailAndLength(ListNode node){
        int length = 1;
        ListNode prev = node;
        node = node.next;
        while (node != null){
            length++;
            prev = node;
            node = node.next;
        }
        return new Result(length, prev);
    }
}
