package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Utility.TreeNode;

public class ListOfDepths {


    public List<List<Integer>> listOfDepths(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        preOrderTraversal(root, 0, list);
        return list;
    }

    private void preOrderTraversal(TreeNode cur, int distance, List<List<Integer>> lists) {
        if (cur != null) {
            List<Integer> list;
            if (distance < lists.size()) {
                list = lists.get(distance);
            } else {
                list = new ArrayList<>();
                lists.add(list);
            }
            list.add(cur.val);

            preOrderTraversal(cur.left, distance + 1, lists);
            preOrderTraversal(cur.right, distance + 1, lists);
        }
    }

    public List<List<Integer>> listOfDepthsBST(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null) queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode curNode = queue.poll();
                list.add(curNode.val);
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
            }
            lists.add(list);
        }
        return lists;
    }
}
