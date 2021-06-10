package DataStructuresAlgorithm;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;
    @BeforeEach
    public void setUp(){
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    @DisplayName("[1,2,3,4,5] reversed is [5,4,3,2,1]")
    public void test1(){
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);


        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        ListNode head = one;

        ListNode curNode = reverseLinkedList.reverseLinkedList(head);
        List<Integer> arr = new ArrayList<>();
        while(curNode != null){
            arr.add(curNode.val);
            curNode = curNode.next;
        }

        assertArrayEquals(new Integer[]{5,4,3,2,1},arr.toArray());

    }

}
