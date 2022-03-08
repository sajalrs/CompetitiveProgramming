package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntersectionTest {
    Intersection intersection;

    @BeforeEach
    public void setup(){
        intersection = new Intersection();
    }

    @Test
    public void test1(){
        ListNode node1 = arrayToList(new int[]{1,4,5,6});
        ListNode node2 = arrayToList(new int[]{2,34,1});
        ListNode node3 = arrayToList(new int[]{12,3});

        getTail(node2).next = node1;
        getTail(node3).next = node1;

        assertEquals(node1, intersection.intersectionN2(node2, node3));
    }

    @Test
    public void test2(){
        ListNode node1 = arrayToList(new int[]{1,4,5,6});
        ListNode node2 = arrayToList(new int[]{2,34,1});
        ListNode node3 = arrayToList(new int[]{12,3});

        getTail(node2).next = node1;
        getTail(node3).next = node1;

        assertEquals(node1, intersection.intersection(node2, node3));
    }

    private ListNode getTail(ListNode node){
        ListNode prev = node;
        node = node.next;
        while (node != null){
            prev = node;
            node = node.next;
        }
        return prev;
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
