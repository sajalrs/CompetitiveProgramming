package CrackingTheCodingInterview;

import Utility.TreeNode;

import java.util.*;

public class PathsWithSum {

    public int pathsWithSum(TreeNode root, int value) {
        TreeNode prev = new TreeNode(0);
        prev.left = root;
        Map<Integer, Integer> lengthFromRoot = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> previousNodes = new ArrayList<>();
        previousNodes.add(-1);
        lengthFromRoot.put(-1, 0);
        lengthFromRoot(root, 0, 0, previousNodes, lengthFromRoot, graph);
        int totalSum = 0;
        for(int node: graph.keySet()){
            int nodeLengthFromRoot = lengthFromRoot.get(node);
            for(int childNode: graph.get(node)){
                int childNodeLengthFromRoot = lengthFromRoot.get(childNode);
                if(childNodeLengthFromRoot - nodeLengthFromRoot == value) totalSum++;
            }
        }
        return totalSum;
    }

    private void lengthFromRoot(TreeNode node, int length, int index, List<Integer> previousNodes, Map<Integer, Integer> lengthFromRoot, Map<Integer, List<Integer>> graph) {
        if(node != null){
            List<Integer> newListOfPreviousNodes = new ArrayList<>();
            for(int previousNode: previousNodes){
                if(!graph.containsKey(previousNode)){
                    graph.put(previousNode, new ArrayList<>());
                }
                graph.get(previousNode).add(index);
                newListOfPreviousNodes.add(previousNode);
            }
            newListOfPreviousNodes.add(index);
            int curLength = node.val + length;
            lengthFromRoot.put(index, curLength);
            lengthFromRoot(node.left, curLength, (2*index)+1, newListOfPreviousNodes, lengthFromRoot, graph);
            lengthFromRoot(node.right, curLength, (2*index)+2, newListOfPreviousNodes, lengthFromRoot, graph);
        }
    }
}
