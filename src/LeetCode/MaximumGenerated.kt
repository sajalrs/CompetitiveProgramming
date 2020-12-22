package LeetCode

import kotlin.math.floor
import kotlin.math.max

fun main() {
    print(getMaximumGenerated(7));
    println(getMaximumGenerated(3));
}

fun getMaximumGenerated(n: Int): Int {
    var dp = Array<Int>(n) { _ -> 0}.toMutableList()
    dp[1] = 1
    var curMax = 1
    for (i in 2 until n) {
        val index = floor((i/2.0)).toInt()
       if(i%2 == 0){
           dp[i] = dp[index]
           curMax = max(dp[i], curMax)
       } else {
           dp[i] = dp[index] + dp[(index) + 1]
           curMax = max(dp[i], curMax)
       }
    }



    return curMax;

}
