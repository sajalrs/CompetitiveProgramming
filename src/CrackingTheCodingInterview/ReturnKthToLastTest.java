package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnKthToLastTest {
    ReturnKthToLast returnKthToLast;

    @BeforeEach
    public void setup(){
        returnKthToLast = new ReturnKthToLast();
    }

    @Test
    public void test1(){
        assertEquals(5,returnKthToLast.returnKthToLast(arrayToList(new int[]{1,2,3,4,5}), 0).val);
        assertEquals(4,returnKthToLast.returnKthToLast(arrayToList(new int[]{1,2,3,4,5}), 1).val);
        assertEquals(1,returnKthToLast.returnKthToLast(arrayToList(new int[]{1,2,3,4,5}), 4).val);
    }

    @Test
    public void test2(){
        assertEquals(5,returnKthToLast.returnKthToLastLengthKnown(arrayToList(new int[]{1,2,3,4,5}), 0).val);
        assertEquals(4,returnKthToLast.returnKthToLastLengthKnown(arrayToList(new int[]{1,2,3,4,5}), 1).val);
        assertEquals(1,returnKthToLast.returnKthToLastLengthKnown(arrayToList(new int[]{1,2,3,4,5}), 4).val);
    }

    @Test
    public void test3(){
        returnKthToLast.returnKthToLastRecursivePrint(arrayToList(new int[]{1,2,3,4,5}), 0); //5
        returnKthToLast.returnKthToLastRecursivePrint(arrayToList(new int[]{1,2,3,4,5}), 1); //4
        returnKthToLast.returnKthToLastRecursivePrint(arrayToList(new int[]{1,2,3,4,5}), 4); //1
    }

    @Test
    public void test4(){
        assertEquals(5,returnKthToLast.returnKthToLastRecursive(arrayToList(new int[]{1,2,3,4,5}), 0).val);
        assertEquals(4,returnKthToLast.returnKthToLastRecursive(arrayToList(new int[]{1,2,3,4,5}), 1).val);
        assertEquals(1,returnKthToLast.returnKthToLastRecursive(arrayToList(new int[]{1,2,3,4,5}), 4).val);
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
