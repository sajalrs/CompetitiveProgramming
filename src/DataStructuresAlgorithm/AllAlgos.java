package DataStructuresAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllAlgos {


    static class TreeNode {
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

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        return arr;
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

//    static int partition(int[] arr, int l, int r){
//        int pivot = arr[r];
//        int origRight = r;
//        r--;
//
//        while(true){
//            while(l<arr.length-1 && arr[l] < pivot){
//                l++;
//            }
//
//            while(r>0 && arr[r] > pivot){
//                r--;
//            }
//
//            if(l>=r){
//                break;
//            }
//
//            int temp = arr[l];
//            arr[l] = arr[r];
//            arr[r] = temp;
//        }
//
//        int temp = arr[l];
//        arr[l] = arr[origRight];
//        arr[origRight] = temp;
//
//        return l;
//    }
//
//    static void quickSort(int[] arr, int l, int r){
//        if(l<=r){
//            int pivot = partition(arr, l, r);
//            quickSort(arr, pivot+1, r);
//            quickSort(arr, l, pivot-1);
//        }
//    }
//
//    static int[] quickSort(int[] arr){
//        quickSort(arr, 0, arr.length-1);
//        return arr;
//    }
//
//    static void merge(int[] arr, int l, int m, int r){
//        int n1 = m- l + 1;
//        int n2 = r - m;
//
//        int[] L = new int[n1];
//        int[] R = new int[n2];
//
//
//        for(int i=0; i<n1;i++){
//            L[i] = arr[l+i];
//        }
//
//        for(int j=0; j< n2; j++){
//            R[j] = arr[m+1+j];
//        }
//
//        int i=0;
//        int j=0;
//        int k=l;
//
//        while(i<n1 && j<n2){
//            if(L[i] < R[j]){
//                arr[k] = L[i];
//                i++;
//            } else {
//                arr[k] = R[j];
//                j++;
//            }
//
//            k++;
//        }
//
//        while(i<n1){
//            arr[k] = L[i];
//            i++;
//            k++;
//        }
//
//        while(j<n2){
//            arr[k] = R[j];
//            j++;
//            k++;
//        }
//    }
//
//    static void mergeSort(int[] arr, int l, int r){
//        if(l<r){
//            int m = (l+r)/2;
//            mergeSort(arr, l, m);
//            mergeSort(arr, m+1, r);
//            merge(arr,l,m,r);
//        }
//    }
//
//    static int[] mergeSort(int[] arr){
//        mergeSort(arr, 0, arr.length-1);
//        return arr;
//    }
//
//    static int binarySearch(int[] arr, int l, int r, int x){
//        if(l<=r){
//            int mid = (l+r)/2;
//            if(arr[mid] == x){
//                return mid;
//            }
//
//            if(arr[mid] < x){
//                return binarySearch(arr, mid+1, r, x);
//            }
//
//            return binarySearch(arr, l, mid-1, x);
//        }
//        return -1;
//    }
//
//    static int binarySearch(int[] arr, int x){
//        return binarySearch(arr, 0, arr.length-1, x);
//    }
//
//    static void levelOrderTraversal(TreeNode curNode){
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(curNode);
//
//        int level = 0;
//        while (!queue.isEmpty()){
//            int levelLength = queue.size();
//            System.out.printf("Level %d%n", level);
//            for(int i =0; i< levelLength; i++){
//                TreeNode temp = queue.poll();
//                System.out.print(temp.val + " ");
//                if(temp.left != null){
//                    queue.add(temp.left);
//                }
//
//                if(temp.right != null){
//                    queue.add(temp.right);
//                }
//            }
//            System.out.println();
//            level++;
//
//        }
//    }
//
//    static void inOrderTraversal(TreeNode curNode){
//        if(curNode == null){
//            return;
//        }
//
//        inOrderTraversal(curNode.left);
//        System.out.print(curNode.val + " ");
//        inOrderTraversal(curNode.right);
//    }
//
//    static void preOrderTraversal(TreeNode curNode){
//        if(curNode == null){
//            return;
//        }
//
//        System.out.print(curNode.val + " ");
//        preOrderTraversal(curNode.left);
//        preOrderTraversal(curNode.right);
//    }
//
//    static void postOrderTraversal(TreeNode curNode){
//        if(curNode==null){
//            return;
//        }
//
//        postOrderTraversal(curNode.left);
//        postOrderTraversal(curNode.right);
//        System.out.print(curNode.val + " ");
//    }
//
//    static int dfs(int at, boolean[] visited, List<List<Edge>> graph){
//        if(visited[at]){
//            return 0;
//        }
//
//        visited[at] = true;
//        int count = 1;
//
//        List<Edge> edges = graph.get(at);
//
//        if(edges!=null){
//            for (Edge edge: edges){
//                count += dfs(edge.to, visited, graph);
//            }
//        }
//        return count;
//    }


    static int dfs(int at, boolean[] visited, List<List<Edge>> graph) {
        if (visited[at]) {
            return 0;
        }

        visited[at] = true;
        int count = 1;
        List<Edge> edges = graph.get(at);

        if (edges != null) {
            for (Edge edge : edges) {
                count += dfs(edge.to, visited, graph);
            }
        }
        return count;
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int origRight = r;
        r--;

        while (true) {

            while (l < arr.length - 1 && arr[l] < pivot) {
                l++;
            }

            while (r > 0 && arr[r] > pivot) {
                r--;
            }

            if (l >= r) {
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        int temp = arr[origRight];
        arr[origRight] = arr[l];
        arr[l] = temp;

        return l;
    }

    static int binarySearch(int[] arr, int l, int r, int x) {
        if (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] < x) {
                return binarySearch(arr, mid + 1, r, x);
            }

            return binarySearch(arr, l, mid - 1, x);
        }
        return -1;
    }

    static int binarySearch(int[] arr, int x) {
        return binarySearch(arr, 0, arr.length - 1, x);
    }

    static void quickSort(int[] arr, int l, int r) {
        if (l <= r) {
            int partition = partition(arr, l, r);
            quickSort(arr, l, partition - 1);
            quickSort(arr, partition + 1, r);
        }
    }

    static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static int[] mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {
            System.out.printf("Level %d%n", level);
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {

                TreeNode curNode = queue.poll();
                System.out.print(curNode.val + " ");
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }

            }

            System.out.println();
            level++;
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 10, -2, 4, 7, 12, -5, 0};
        System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(quickSort(arr)));
        System.out.println(Arrays.toString(mergeSort(arr)));
        System.out.println(binarySearch(insertionSort(arr), 7));

        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        left.right = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left = left;
        levelOrderTraversal(root);
//        System.out.println();
//        inOrderTraversal(root);
//
//        System.out.println();
//        postOrderTraversal(root);
//
//        System.out.println();
//        preOrderTraversal(root);

    }
}
