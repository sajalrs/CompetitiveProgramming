package uvaonline

import java.util.*

fun main(){
    val scanner = Scanner(System.`in`)

    var newLine = scanner.nextLine()
    while(newLine!="0 0 0 0 0"){
        val numChoices = newLine.split(" ").map { str -> str.toInt() }
        println(numChoices)
        println(computeTwentyThreeOutofFive(numChoices))
        newLine = scanner.nextLine()
    }


}

fun computeTwentyThreeOutofFive(arr: List<Int>):String{
    var found = false
    var vis = MutableList<Boolean>(5) { _ -> false}

    fun backTrack(len: Int, value: Int, first: Int){
        if(found){
            return
        }

        if(len==5){
            found = (value == 23)
            return
        }

        for(j in 0 until 5){
            if(vis[j]){
                continue

            }
            vis[j] = true

            if(first==1){
                backTrack(len+1, value + arr[j],1)
                backTrack(len+1, value - arr[j],1)
                backTrack(len+1, value * arr[j],1)
            } else {
                backTrack(len+1,arr[j],1)
            }
            vis[j] = false
        }
    }

    backTrack(0,0,0)
    return if(found){
        "Possible"
    } else {
        "Impossible"
    }
}