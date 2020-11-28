package DataStructuresAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {


    private static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

     private static class BinaryTree {
        Node root;

        BinaryTree(){
            root = null;
        }

        void printLevelOrder() {
            if (root == null) {
                return;
            }
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            int level = 0;

            while (!queue.isEmpty()) {

                int levelLength = queue.size();
                System.out.printf("Level %d%n", level);
                for (int i = 0; i < levelLength; i++) {
                    Node tempNode = queue.poll();
                    System.out.print(tempNode.data + " ");

                    if (tempNode.left != null) {
                        queue.add(tempNode.left);
                    }

                    if (tempNode.right != null) {
                        queue.add(tempNode.right);
                    }
                }

                System.out.println();
                level++;
            }
        }
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(3);
        Node one = new Node(9);
        Node two = new Node(20);
        Node three = new Node(15);
        Node four = new Node(7);

        two.left= three;
        two.right=four;

        root.left = one;
        root.right = two;

        binaryTree.root = root;
        binaryTree.printLevelOrder();
    }

}
