package LeetCode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 */


fun swapPairs(orig: ListNode?): ListNode? {
    var head = orig
    var dummy = ListNode(-1)
    dummy.next = head
    var prevNode = dummy

    while((head != null) && (head.next != null)){
        var firstNode = head
        var secondNode = head.next

        prevNode.next = secondNode
        firstNode.next = secondNode?.next
        secondNode?.next = firstNode

        prevNode = firstNode
        head = firstNode.next

    }

    return dummy.next

}