package LeetCode
/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.



Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.


Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
 */
fun main(){
    print(findKthPositive(arrayOf(1,13,18).toIntArray(), 17))
}



fun findKthPositive(arr: IntArray, k:Int): Int{
    var counter = 0
    fun positiveWithin(arr: IntArray, k:Int): Int{
        var posNumber: Int
        for(l in 1 until arr[0]){
            posNumber = l
            counter++
            if(counter == k){
                return posNumber
            }
        }
        for(i in 1 until arr.size){
            for(j in arr[i-1]+1 until arr[i]){
                posNumber = j
                counter++
                if(counter == k){
                    return posNumber
                }
            }

        }

        return -1
    }

    var toReturn = positiveWithin(arr,k)
    if(toReturn == -1){
        toReturn = arr[arr.size-1]
        while(counter != k){
            counter++
            toReturn++
        }
    }
    return toReturn
}