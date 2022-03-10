package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeTest {
    Palindrome palindrome;
    @BeforeEach
    public void setup(){
        palindrome = new Palindrome();
    }

    @Test
    public void test1(){
        assertEquals(true, palindrome.palindrome(arrayToList(new int[]{1,0,1})));
    }

    @Test
    public void test2(){
        assertEquals(true, palindrome.palindrome(arrayToList(new int[]{1,1})));
    }

    @Test
    public void test3(){
        assertEquals(false, palindrome.palindrome(arrayToList(new int[]{1,1,0})));
    }

    @Test
    public void test4(){
        assertEquals(true, palindrome.palindromeReversed(arrayToList(new int[]{1,0,1})));
    }

    @Test
    public void test5(){
        assertEquals(true, palindrome.palindromeReversed(arrayToList(new int[]{1,1})));
    }

    @Test
    public void test6() {
        assertEquals(false, palindrome.palindromeReversed(arrayToList(new int[]{1, 1, 0})));
    }

    @Test
    public void test7() {
        assertEquals(true, palindrome.palindromeReversed(arrayToList(new int[]{})));
    }

    @Test
    public void test8() {
        assertEquals(true, palindrome.palindromeReversed(null));
    }

    @Test
    public void test9(){
        assertEquals(true, palindrome.palindromeRecursive(arrayToList(new int[]{1,0,1})));
    }

    @Test
    public void test10(){
        assertEquals(true, palindrome.palindromeRecursive(arrayToList(new int[]{1,1})));
    }

    @Test
    public void test11(){
        assertEquals(false, palindrome.palindromeRecursive(arrayToList(new int[]{1,1,0})));
    }
    @Test
    public void test12(){
        assertEquals(true, palindrome.palindromeRecursive(arrayToList(new int[]{1,2,3,3,2,1})));
    }

    @Test
    public void test13(){
        assertEquals(false, palindrome.palindromeRecursive(arrayToList(new int[]{1,2,3,3,2,1,12})));
    }
    @Test
    public void test14(){
        assertEquals(true, palindrome.palindromeRecursive(arrayToList(new int[]{1,2,3,4,3,2,1})));
    }

    @Test
    public void test15(){
        assertEquals(true, palindrome.palindrome(arrayToList(new int[]{1,2,3,3,2,1})));
    }

    @Test
    public void test16(){
        assertEquals(true, palindrome.palindromeReversed(arrayToList(new int[]{1,2,3,3,2,1})));
    }

    private ListNode arrayToList(int[] array) {
        if(array.length == 0) return null;
        ListNode cur = new ListNode(array[0]);
        ListNode head = cur;
        for (int i = 1; i < array.length; i++) {
            ListNode prev = cur;
            cur = new ListNode(array[i]);
            prev.next = cur;
        }
        return head;
    }

    private int[] listToArray(ListNode listNode) {
        if(listNode == null) return new int[]{};
        ListNode cur = listNode;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] arr = new int[count];
        int index = 0;
        cur = listNode;
        while (cur != null) {
            arr[index] = cur.val;
            cur = cur.next;
            index++;
        }
        return arr;
    }
}
