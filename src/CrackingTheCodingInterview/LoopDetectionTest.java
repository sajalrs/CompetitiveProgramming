package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopDetectionTest {
    LoopDetection loopDetection;
    @BeforeEach
    public void setup(){
        loopDetection = new LoopDetection();
    }

    @Test
    public void test1(){
        ListNode cur = arrayToList(new int[]{1,4,2,1,0});
        ListNode temp = cur;
        ListNode prev = cur;
        cur = cur.next;

        while (cur!=null){
            prev = cur;
            cur = cur.next;
        }
        prev.next = temp;
        assertEquals(temp,loopDetection.loopDetection(temp));
    }

    @Test
    public void test2(){
        ListNode cur = arrayToList(new int[]{1,4,2,1,0});
        ListNode temp = cur;
        ListNode prev = cur;
        cur = cur.next;

        while (cur!=null){
            prev = cur;
            cur = cur.next;
        }
        assertEquals(null,loopDetection.loopDetection(temp));
    }

    @Test
    public void test3(){
        ListNode cur = arrayToList(new int[]{1,4,2,1,0});
        ListNode temp = cur;
        ListNode prev = cur;
        cur = cur.next;

        while (cur!=null){
            prev = cur;
            cur = cur.next;
        }
        assertEquals(null,loopDetection.loopDetection2Runner(temp));
    }

    @Test
    public void test4(){
        ListNode cur = arrayToList(new int[]{1,4,2,1,0});
        ListNode temp = cur;
        ListNode prev = cur;
        cur = cur.next;

        while (cur!=null){
            prev = cur;
            cur = cur.next;
        }
        prev.next = temp;
        assertEquals(temp,loopDetection.loopDetection2Runner(temp));
    }

    @Test
    public void test5(){
        ListNode cur = arrayToList(new int[]{1,4,2,1,0});
        ListNode head = cur;
        ListNode prev = cur;
        cur = cur.next;

        for(int i = 0; i<2; i++){
            prev = prev.next;
            cur = cur.next;
        }

        ListNode temp = prev;

        while (cur != null){
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = temp;
        assertEquals(temp,loopDetection.loopDetection2Runner(head));
    }

    private ListNode arrayToList(int[] array) {
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
