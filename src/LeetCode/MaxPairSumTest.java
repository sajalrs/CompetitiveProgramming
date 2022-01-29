package LeetCode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPairSumTest {
    MaxPairSum maxPairSum;

    @BeforeEach
    public void setup(){
        maxPairSum = new MaxPairSum();
    }

    @Test
    @DisplayName("Input: head = [5,4,2,1]\n" +
            "Output: 6\n" +
            "Explanation:\n" +
            "Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.\n" +
            "There are no other nodes with twins in the linked list.\n" +
            "Thus, the maximum twin sum of the linked list is 6. ")
    public void test1(){
        ListNode head = arrayToList(new int[]{5,4,2,1});
        assertEquals(6, maxPairSum.pairSum(head));
    }

    @Test
    @DisplayName("Input: head = [4,2,2,3]\n" +
            "Output: 7\n" +
            "Explanation:\n" +
            "The nodes with twins present in this linked list are:\n" +
            "- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.\n" +
            "- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.\n" +
            "Thus, the maximum twin sum of the linked list is max(7, 4) = 7. ")
    public void test2(){
        ListNode head = arrayToList(new int[]{4,2,2,3});
        assertEquals(7, maxPairSum.pairSum(head));
    }

    @Test
    @DisplayName("Input: head = [1,100000]\n" +
            "Output: 100001\n" +
            "Explanation:\n" +
            "There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.")
    public void test3(){
        ListNode head = arrayToList(new int[]{1,100000});
        assertEquals(100001, maxPairSum.pairSum(head));
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
}
