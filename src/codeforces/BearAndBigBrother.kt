package codeforces

/**
 * Bear Limak wants to become the largest of bears, or at least to become larger than his brother Bob.

Right now, Limak and Bob weigh a and b respectively. It's guaranteed that Limak's weight is smaller than or equal to his brother's weight.

Limak eats a lot and his weight is tripled after every year, while Bob's weight is doubled after every year.

After how many full years will Limak become strictly larger (strictly heavier) than Bob?

Input
The only line of the input contains two integers a and b (1 ≤ a ≤ b ≤ 10) — the weight of Limak and the weight of Bob respectively.

Output
Print one integer, denoting the integer number of years after which Limak will become strictly larger than Bob.
 */
import java.util.*

fun main(args: Array<String>){
    val scanner = Scanner(System.`in`)
    val (limakString, bobString) = scanner.nextLine().split(" ")
    var limak = limakString.toInt()
    var bob = bobString.toInt()
    var counter = 0
    while(limak <= bob){
        counter++
        limak*=3
        bob*=2
    }
    System.out.println(counter)
}