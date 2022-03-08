package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SumListsTest {

    SumLists sumLists;
    @BeforeEach
    public  void setup(){
        sumLists = new SumLists();
    }

    @Test
    public void test1(){
        assertArrayEquals(new int[]{3,3,5},listToArray(sumLists.sumListsReversed(arrayToList(new int[]{1,2,5}), arrayToList(new int[]{2,1}))));
    }


    @Test
    public void test2(){
        assertArrayEquals(new int[]{1,1,6},listToArray(sumLists.sumListsReversed(arrayToList(new int[]{9,9,5}), arrayToList(new int[]{2,1}))));
    }

    @Test
    public void test3(){
        assertArrayEquals(new int[]{1,4,6},listToArray(sumLists.sumListsForward(arrayToList(new int[]{1,2,5}), arrayToList(new int[]{2,1}))));
    }


    @Test
    public void test4(){
        assertArrayEquals(new int[]{1,0,1,6},listToArray(sumLists.sumListsForward(arrayToList(new int[]{9,9,5}), arrayToList(new int[]{2,1}))));
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
