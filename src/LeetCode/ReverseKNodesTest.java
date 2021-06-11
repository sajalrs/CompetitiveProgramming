package LeetCode;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseKNodesTest {

    private ReverseKNodes reverseKNodes;

    @BeforeEach
    public void setUp(){
        reverseKNodes = new ReverseKNodes();
    }

    @Test
    @DisplayName("Reverse 2 Nodes in [1,2,3,4,5]")
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

        ListNode curNode = reverseKNodes.reverseKGroup(head, 2);
        List<Integer> arr = new ArrayList<>();
        while(curNode != null){
            arr.add(curNode.val);
            curNode = curNode.next;
        }
        System.out.println(arr);
        assertArrayEquals(new Integer[]{2,1,4,3,5},arr.toArray());
    }


}
