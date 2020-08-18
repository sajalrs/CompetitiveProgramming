package LeetCode

fun main(){
    print(threeSum(intArrayOf(3,0,-2,-1,1,2)))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    var set: MutableSet<List<Int>> = mutableSetOf()
    nums.sort()

    for(i in 1 until nums.lastIndex){
        var left = i-1
        var right = i+1


        var sum: Int
        while(true){
            sum = nums[left] + nums[i] + nums[right]
            if(sum == 0){
                val toAdd = listOf<Int>(nums[left], nums[i], nums[right])
                set.add(toAdd)
                if(right+1 <= nums.lastIndex && left-1 > -1){
                    right++
                    left++
                } else{
                    break;
                }
            }
            if(sum > 0){
                if(left-1 > -1){
                    left--
                } else{
                    break
                }
            } else if(sum<0) {
                if(right+1 <= nums.lastIndex){
                    right++
                } else {
                    break
                }
            }

        }
        sum = nums[left] + nums[i] + nums[right]


    }

    return set.toList()

}