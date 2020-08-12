package Kattis

import java.math.BigInteger
import java.util.*

fun main(){
    fun calculateCn(number: Int): BigInteger {

        fun factorial(a: Int): BigInteger {
            return if(a==0){
                BigInteger.ONE
            } else {
                a.toBigInteger() * factorial(a-1)
            }
        }

        fun combinations(n: Int, r:Int): BigInteger {
            if(r==0){
                return BigInteger.ONE
            }
            if(n == 0){
                return BigInteger.ZERO
            }
            return factorial(n)/(factorial(n-r)*factorial(r))
        }

        return combinations(2*number,number)/(number+1).toBigInteger()
    }

    val scr = Scanner(System.`in`)
    val n = scr.nextInt()

    var sum = BigInteger.ZERO
    for(i in 0 until n+1){
        sum += calculateCn(i)* calculateCn(n-i)
    }
    println(sum)
}

class CatalanSquare {
}