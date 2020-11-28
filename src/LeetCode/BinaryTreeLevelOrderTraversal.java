package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<Integer>());
            int levelLength = queue.size();
            for(int i=0; i< levelLength; i++){
                TreeNode node = queue.poll();
                levels.get(level).add(node.val);

                if(node.left !=null ){
                    queue.add(node.left);
                }

                if(node.right !=null){
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levels;
    }

}
