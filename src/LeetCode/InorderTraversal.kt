/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 */
package LeetCode

fun main() {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {

        var inOrderList = emptyList<Int>().toMutableList()


        fun recursiveInorder(curNode: TreeNode) {
            if (curNode.left != null) {
                recursiveInorder(curNode.left!!)
            }
            inOrderList.add(curNode.`val`)
            if (curNode.right != null) {
                recursiveInorder(curNode.right!!)
            }
        }

        if(root != null){
            recursiveInorder(root!!)
        }
        return inOrderList
    }

    var root = TreeNode(1)
    var left = TreeNode(2)
    root.right = left

    val inOrderList = inorderTraversal(root)

    for (num in inOrderList) {
        print(num)
    }




}

