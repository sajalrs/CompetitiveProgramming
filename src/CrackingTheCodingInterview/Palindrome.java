package CrackingTheCodingInterview;

import LeetCode.ListNode;

import java.util.Stack;

public class Palindrome {
    public boolean palindrome(ListNode head){
        ListNode runner = head;
        Stack<Integer> stack = new Stack<>();
        while (runner != null && runner.next != null){
            stack.add(head.val);
            runner = runner.next.next;
            head = head.next;
        }
        if(runner!= null) {
            head = head.next;
        }
        while (head !=null){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean palindromeReversed(ListNode head){
        int count=0;
        ListNode cur = head;
        while (cur!=null){
            count++;
            cur = cur.next;
        }

        count = count/2;
        ListNode reversed = reverse(head);
        for(int i=0; i<count; i++){
            if(head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node){
        ListNode head = null;
        while (node != null){
            ListNode newNode = new ListNode(node.val);
            newNode.next = head;
            head = newNode;
            node = node.next;
        }
        return head;
    }

    public boolean palindromeRecursive(ListNode head){
        int count=0;
        ListNode cur = head;
        while (cur!=null){
            count++;
            cur = cur.next;
        }

        Result result = new Result(null, false);
        palindromeRecursiveHelper(count, head, result);
        return result.isMatched;
    }

    private class Result{
        ListNode node;
        boolean isMatched;
        public Result(ListNode node, boolean isMatched){
            this.node = node;
            this.isMatched = isMatched;
        }
    }

    private void palindromeRecursiveHelper(int length, ListNode node, Result lastResult){
        if(length != 0 && length != 1){
            palindromeRecursiveHelper(length - 2, node.next, lastResult);
        }

        if(length == 0 || length == 1){
            lastResult.node = length == 1 ? node.next : node ;
            lastResult.isMatched = true;
            return;
        }

        if(lastResult.isMatched == false){
            lastResult.isMatched = false;
            return;
        }

        if(node.val == lastResult.node.val){
            lastResult.isMatched = true;
            lastResult.node = lastResult.node.next;
            return;
        }else{
            lastResult.isMatched = false;
            return;
        }
    }


}
