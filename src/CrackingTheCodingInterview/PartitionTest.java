package CrackingTheCodingInterview;

import LeetCode.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitionTest {
    Partition partition;
    @BeforeEach
    public void setup(){
        partition = new Partition();
    }

    @Test
    public void test1(){
        ListNode list = arrayToList(new int[]{1,12,4,21,0,91,8});
        ListNode seperated = partition.partition(list, 8);
        assertEquals(true, checkPartition(listToArray(seperated),8));
    }

    @Test
    public void test2(){
        ListNode list = arrayToList(new int[]{8,1,12,4,21,0,91,8});
        ListNode seperated = partition.partition(list, 8);
        assertEquals(true, checkPartition(listToArray(seperated),8));
    }

    @Test
    public void test3(){
        ListNode list = arrayToList(new int[]{8,1,12,4,21,0,91,8});
        ListNode seperated = partition.partitionTwoLists(list, 8);
        System.out.println(Arrays.toString(listToArray(seperated)));
        assertEquals(true, checkPartition(listToArray(seperated),8));
    }

    public boolean checkPartition(int[] arr, int x){
        int index = Arrays.binarySearch(arr, x);
        if(index == -1) return true;
        int starts = index;
        while (starts > 0 && arr[starts] == x){
            starts--;
        }
        int ends = index;
        while (ends < arr.length && arr[ends] == x){
            ends++;
        }

        for(int i=0; i<starts; i++){
            if(arr[i] >= x) return false;
        }

        for(int i=ends+1; i<arr.length; i++){
            if(arr[i] <= x) return false;
        }
        return true;
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
