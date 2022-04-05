package CrackingTheCodingInterview;

import Utility.TreeNode;

import java.util.Random;

public class RandomNodeBST implements BinarySearchTree {
    private TreeNode root;
    private int size = 0;

    RandomNodeBST(int val) {
        root = new TreeNode(val);
    }

    RandomNodeBST() {
    }

    private class Counter{
        int value = 0;
    }

    private class TreeNodeWrapper {
        TreeNode node = null;

        TreeNodeWrapper(TreeNode node) {
            this.node = node;
        }

        TreeNodeWrapper() {
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    @Override
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode node = new TreeNode(val);
        insertHelper(root, node);
        size++;
    }

    private void insertHelper(TreeNode node, TreeNode toInsert) {
        if (node != null && toInsert != null) {
            if (node.val >= toInsert.val) {
                if (node.left != null) {
                    insertHelper(node.left, toInsert);
                } else {
                    node.left = toInsert;
                }
            } else {
                if (node.right != null) {
                    insertHelper(node.right, toInsert);
                } else {
                    node.right = toInsert;
                }
            }
        }
    }

    @Override
    public TreeNode find(int val) {
        return findHelper(root, val);
    }

    private TreeNode findHelper(TreeNode node, int val) {
        if (node != null) {
            if (node.val == val) return node;
            if (val < node.val) return findHelper(node.left, val);
            if (val > node.val) return findHelper(node.right, val);
        }
        return null;
    }

    @Override
    public void delete(int val) {
        if (size == 0) return;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        prev.left = root;
        deleteHelper(root, new TreeNodeWrapper(prev), val, true);
        root = prev.left;
        size--;
    }

    public int getRandomNode() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int randomNumber = new Random().nextInt(size - 1);
        TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper();
        getRandomNodeHelper(new Counter(), randomNumber, root, treeNodeWrapper);
        return treeNodeWrapper.node.val;
    }

    private void getRandomNodeHelper(Counter counter, int randomNode, TreeNode node, TreeNodeWrapper treeNodeWrapper) {
        if (treeNodeWrapper.node != null) return;
        if (node != null) {
            if (counter.value == randomNode) {
                treeNodeWrapper.node = node;
            }
            counter.value++;
            getRandomNodeHelper(counter, randomNode, node.left, treeNodeWrapper);
            getRandomNodeHelper(counter, randomNode, node.right, treeNodeWrapper);
        }
    }

    private void deleteHelper(TreeNode node, TreeNodeWrapper prev, int val, boolean isMovingLeft) {
        if (node != null) {
            if (node.val == val) {
                if (node.left == null) {
                    if (isMovingLeft) {
                        prev.node.left = node.right;
                    } else {
                        prev.node.right = node.right;
                    }
                    return;
                }
                if (node.right == null) {
                    if (isMovingLeft) {
                        prev.node.left = node.left;
                    } else {
                        prev.node.right = node.left;
                    }
                    return;
                }
                TreeNodeWrapper firstInorderNeighborWrapper = new TreeNodeWrapper();
                TreeNodeWrapper firstInorderNeighborPrevWrapper = new TreeNodeWrapper();
                firstInorderNode(node.right, firstInorderNeighborWrapper, firstInorderNeighborPrevWrapper, node);

                TreeNode cur = firstInorderNeighborWrapper.node;
                TreeNode prevCur = firstInorderNeighborPrevWrapper.node;

                if (prevCur.left == cur) {
                    prevCur.left = null;
                } else {
                    prevCur.right = null;
                }

                if (isMovingLeft) {
                    prev.node.left = cur;
                } else {
                    prev.node.right = cur;
                }
                cur.left = node.left;
                cur.right = node.right;
                return;
            }
            if (val < node.val) {
                deleteHelper(node.left, new TreeNodeWrapper(node), val, true);
            }
            if (val > node.val) {
                deleteHelper(node.right, new TreeNodeWrapper(node), val, false);
            }
        }
    }

    private void firstInorderNode(TreeNode cur, TreeNodeWrapper treeNodeWrapper, TreeNodeWrapper prevNodeWrapper, TreeNode prev) {
        if (treeNodeWrapper.node != null) return;
        if (cur != null) {
            firstInorderNode(cur.left, treeNodeWrapper, prevNodeWrapper, cur);
            if (treeNodeWrapper.node == null) {
                treeNodeWrapper.node = cur;
                prevNodeWrapper.node = prev;
            }
            firstInorderNode(cur.right, treeNodeWrapper, prevNodeWrapper, cur);
        }
    }
}
