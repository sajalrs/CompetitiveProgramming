package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RemoveDupsTest {
    RemoveDups removeDups;
    @BeforeEach
    public void setup(){
        removeDups = new RemoveDups();
    }

    @Test
    @DisplayName("Input: [1,4,4,2,12,25,12], Output: [1,4,2,12,25]")
    public void testBuffer(){
        ListNode withDups = arrayToList(new int[]{1,4,4,2,12,25,12});
        removeDups.removeDupsBuffer(withDups);
        assertArrayEquals(new int[]{1,4,2,12,25},listToArray(withDups));
    }

    @Test
    @DisplayName("Input: [1,4,4,2,12,25,12], Output: [1,4,2,12,25]")
    public void testNoBuffer(){
        ListNode withDups = arrayToList(new int[]{1,4,4,2,12,25,12});
        removeDups.removeDupsNoBuffer(withDups);
        System.out.println(Arrays.toString(listToArray(withDups)));
        assertArrayEquals(new int[]{1,4,2,12,25},listToArray(withDups));
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
