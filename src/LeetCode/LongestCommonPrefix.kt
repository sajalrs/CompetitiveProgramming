package LeetCode

import java.lang.StringBuilder

import kotlin.math.min


fun main(){
    print(longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(longestCommonPrefix(arrayOf("dog","racecar","car")))
    println(longestCommonPrefix(arrayOf("aca","cba")))
}

fun longestCommonPrefix(strs: Array<String>): String {

    if(strs.isEmpty()){
        return ""
    }

    var common = strs[0]
    for(i in 1 until strs.lastIndex+1){
        var betweenTwo = StringBuilder()
        for(j in -1 until min(strs[i].lastIndex,common.lastIndex)){
            if(common[j+1] == strs[i][j+1]){
                betweenTwo.append(common[j+1])
            } else {
                break
            }
        }
        common = betweenTwo.toString()
    }
    return common.toString()
}