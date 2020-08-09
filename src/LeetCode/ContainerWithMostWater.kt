package LeetCode
/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

 */
fun main(){
    print(maxArea(arrayOf(1,8,6,2,5,4,8,3,7).toIntArray()))
}

fun maxArea(height: IntArray):Int{

    var greatestArea = 0
    var left = 0
    var right = height.size-1

    while(left<right){
        var area = 0
        if(height[left]<height[right]){
            area = height[left] * (right - left)
            left++
        } else {
            area = height[right] * (right - left)
            right--
        }
        greatestArea = Math.max(area,greatestArea)
    }
    return greatestArea
}