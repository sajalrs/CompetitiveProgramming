package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseEvenLengthGroupsTest {
    ReverseEvenLengthGroups reverseEvenLengthGroups;

    @BeforeEach
    public void setup() {
        reverseEvenLengthGroups = new ReverseEvenLengthGroups();
    }

    @Test
    @DisplayName("Testing Test Helper Methods")
    public void testHelpersTest() {
        assertArrayEquals(listToArray(arrayToList(new int[]{1, 2, 3})), new int[]{1, 2, 3});
    }

    @Test
    @DisplayName("Input: head = [5,2,6,3,9,1,7,3,8,4]\n" +
            " Output: [5,6,2,3,9,1,4,8,3,7]")
    public void test1() {
        int[] rev = listToArray(reverseEvenLengthGroups.reverseEvenLengthGroups(arrayToList(new int[]{5,2,6,3,9,1,7,3,8,4})));
        assertArrayEquals(new int[]{5,6,2,3,9,1,4,8,3,7}, rev);
    }

    @Test
    @DisplayName("Input: head = [1,1,0,6]\n" +
            " Output: [1,0,1,6]")
    public void test2() {
        int[] rev = listToArray(reverseEvenLengthGroups.reverseEvenLengthGroups(arrayToList(new int[]{1,1,0,6})));
        assertArrayEquals(new int[]{1,0,1,6}, rev);

    }

    @Test
    @DisplayName("Input: head = [2,1]\n" +
            " Output: [2,1]")
    public void test3() {
        int[] rev = listToArray(reverseEvenLengthGroups.reverseEvenLengthGroups(arrayToList(new int[]{2,1})));
        assertArrayEquals(new int[]{2,1}, rev);

    }

    @Test
    @DisplayName("Input: head = [0,4,2,1,3]\n" +
            " Output: [0,2,4,3,1]")
    public void test4() {
        int[] rev =  listToArray(reverseEvenLengthGroups.reverseEvenLengthGroups(arrayToList(new int[]{0,4,2,1,3})));
        System.out.println(Arrays.toString(rev));
        assertArrayEquals(new int[]{0,2,4,3,1}, rev);

    }

    @Test
    @DisplayName("Input: head = [8]\n" +
            " Output: [8]")
    public void test5() {
        int[] rev = listToArray(reverseEvenLengthGroups.reverseEvenLengthGroups(arrayToList(new int[]{8})));
        assertArrayEquals(new int[]{8}, rev);

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
