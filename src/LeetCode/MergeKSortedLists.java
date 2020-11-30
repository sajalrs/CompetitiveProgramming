package LeetCode;

public class MergeKSortedLists {

    public class ListNode {
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

    ListNode mergeLinkedLists(ListNode L, ListNode R) {

        ListNode curK = new ListNode();
        ListNode toReturn = curK;


        ListNode curL = L, curR = R;

        while (curL != null && curR != null) {
            if (curL.val < curR.val) {
                curK.next = new ListNode(curL.val);
                curL = curL.next;
            } else {
                curK.next = new ListNode(curR.val);
                curR = curR.next;
            }
            curK=curK.next;
        }

        if (curL != null) {
            curK.next = curL;
        }

        if (curR != null) {
            curK.next = curR;
        }

        return toReturn.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode curList = null;
        for(ListNode list: lists){

            curList = mergeLinkedLists(curList, list);
        }
        if(curList != null){
            return curList;
        } else{
            return new ListNode();
        }
    }

}
