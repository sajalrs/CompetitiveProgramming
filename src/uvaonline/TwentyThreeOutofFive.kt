package uvaonline
/*
Your task is to write a program that can decide whether you can find an arithmetic expression consisting
of five given numbers ai (1 ≤ i ≤ 5) that will yield the value 23.
For this problem we will only consider arithmetic expressions of the following from:
(((aπ(1) o1 aπ(2)) o2 aπ(3)) o3 aπ(4)) o4 aπ(5)
where π : {1, 2, 3, 4, 5} → {1, 2, 3, 4, 5} is a bijective function and oi ∈ {+, −, ∗}(1 ≤ i ≤ 4)
Input
The Input consists of 5-Tupels of positive Integers, each between 1 and 50.
Input is terminated by a line containing five zero’s. This line should not be processed. Input file
will have no more than 25 lines.
Output
For each 5-Tupel print ‘Possible’ (without quotes) if their exists an arithmetic expression (as described
above) that yields 23. Otherwise print ‘Impossible’.
Sample Input
1 1 1 1 1
1 2 3 4 5
2 3 5 7 11
0 0 0 0 0
Sample Output
Impossible
Possible
Possible
 */
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