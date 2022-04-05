package CrackingTheCodingInterview;

import Utility.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BSTSequences {
    public List<int[]> BSTSequences(TreeNode root){
        return postOrderTraversal(root);
    }

    private List<int[]> postOrderTraversal(TreeNode node){
        if(node != null){
            List<int[]> leftList =postOrderTraversal(node.left);
            List<int[]> rightList = postOrderTraversal(node.right);

            List<int[]> merged = new LinkedList<>();
            int[] curArr = new int[]{node.val};

            if(leftList.isEmpty() && rightList.isEmpty()) {
                merged.add(curArr);
                return merged;
            }else if(leftList.isEmpty()){
                for(int[] arr1: leftList){
                    merged.add(merge(curArr, arr1));
                }
            } else if(rightList.isEmpty()){
                for(int[] arr1: rightList){
                    merged.add(merge(curArr, arr1));
                }
                return merged;
            }else {
                for(int[] arr1: leftList){
                    for(int[] arr2: rightList){
                        merged.add(merge(curArr,merge(arr1, arr2)));
                        merged.add(merge(curArr,merge(arr2, arr1)));
                    }
                }
            }
            return merged;
        }
        return new LinkedList<>();
    }

    private int[] merge(int[] arr1, int[] arr2){
        int[] newArr = new int[arr1.length + arr2.length];
        int k=0;
        for(int i=0; i<arr1.length; i++){
            newArr[k] = arr1[i];
            k++;
        }

        for(int j=0; j<arr2.length; j++){
            newArr[k] = arr2[j];
            k++;
        }
        return newArr;
    }
}
