package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DeleteMiddleNodeTest {
    DeleteMiddleNode deleteMiddleNode;
    @BeforeEach
    public void setup(){
        deleteMiddleNode = new DeleteMiddleNode();
    }

    @Test
    public void test1(){
        ListNode node = arrayToList(new int[]{1,2,3,4,5});
        deleteMiddleNode.deleteMiddleNode(node.next);
        assertArrayEquals(new int[]{1,3,4,5},listToArray(node));
    }
    @Test
    public void test2(){
        ListNode node = arrayToList(new int[]{1,2,3,4,5});
        deleteMiddleNode.deleteMiddleNode(node.next.next);
        assertArrayEquals(new int[]{1,2,4,5},listToArray(node));
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
