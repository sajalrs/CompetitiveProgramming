package LeetCode;

import java.util.*;

public class CreateBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        Set<Integer> root = new HashSet<>();
        List<Integer> children = new ArrayList<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int direction = description[2];
            root.add(parent);
            children.add(child);
            if (direction == 1) {
                if(!graph.containsKey(parent)){
                    graph.put(parent, new HashMap<>());
                }
                graph.get(parent).put(child, 1);

            } else {
                if(!graph.containsKey(parent)){
                    graph.put(parent, new HashMap<>());
                }
                graph.get(parent).put(child, 2);
            }
        }

        for (int child : children) {
            if (root.contains(child)) {
                root.remove(child);
            }
        }

        TreeNode parent = new TreeNode((int) root.toArray()[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(graph.containsKey(cur.val)){
                for (int i: graph.get(cur.val).keySet()) {
                    if (graph.get(cur.val).get(i) == 1) {
                        TreeNode left = new TreeNode(i);
                        cur.left = left;
                        queue.add(left);
                    } else if (graph.get(cur.val).get(i) == 2) {
                        TreeNode right = new TreeNode(i);
                        cur.right =  right;
                        queue.add(right);
                    }
                }
            }
        }
        return parent;
    }
}
