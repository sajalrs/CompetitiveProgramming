package LeetCode

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */
fun main(){
    println(isPalindrome(121))
    println(isPalindrome(-121))
    println(isPalindrome(10))
}

fun isPalindrome(x:Int): Boolean {
    if(x < 0){
        return false
    }

    var number = x
    var revNumber = 0
    while(number>0){
        val lastDigit = number%10
        number = (number-lastDigit)/10
        revNumber = (revNumber*10)+lastDigit
    }

    return revNumber==x
}