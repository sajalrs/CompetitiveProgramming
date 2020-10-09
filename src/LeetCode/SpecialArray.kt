package LeetCode

fun main(){
    var array = intArrayOf(3,6,7,7,0)
    print(specialArray(array))
}

fun specialArray(nums: IntArray): Int{

    for(i in 0 until nums.size+1) {
        var numGreater = 0
        for(j in nums.indices){
            if(nums[j]>=i){
                numGreater++
            }

            if(numGreater>i){
                break
            }

            if(numGreater + (nums.size - j + 1) < i){
                break
            }
        }
        if(i == numGreater){
            return numGreater
        }

    }

    return -1
}