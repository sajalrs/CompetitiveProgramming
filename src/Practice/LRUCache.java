package Practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node{
        Node left;
        Node right;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int size = 0;
    int capacity;
    Map<Integer, Node> map  = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curNode = map.get(key);
        if(head != curNode){
            if(curNode.left != null) curNode.left.right = curNode.right;
            if(curNode.right != null) curNode.right.left = curNode.left;
            if(curNode == tail){
                tail = curNode.left;
            }
            curNode.left = null;
            curNode.right = head;
            if(head != null) head.left = curNode;
            head = curNode;
            if(tail == null) tail = curNode;
        }
        return curNode.value;
    }

    public void put(int key, int value) {
        if(size > capacity){
            Node removedNode = tail;
            tail = removedNode.left;
            if(tail != null) tail.right = null;
            if(removedNode == head) head = null;
            removedNode.left = null;
            map.remove(removedNode.key);
            size--;
        }

        Node curNode;
        if(!map.containsKey(key)){
            curNode = new Node(key, value);
            if(head == null && tail == null){
                head = curNode;
            } else {
                tail.right = curNode;
                curNode.left = tail;
            }
            tail = curNode;
        }else {
            curNode = map.get(key);
            curNode.value = value;
            if(curNode.left != null) curNode.left.right = curNode.right;
            curNode.left = null;
            curNode.right = head;
            head.left = curNode;
            head = curNode;
        }
        map.put(key, curNode);
        size++;
    }


}
