package LeetCode

import kotlin.math.max

import java.util.ArrayDeque

fun main(){
    print(longestValidParentheses("(()"))
}

fun longestValidParentheses(s: String): Int {

    var parenthesesStack = ArrayDeque<Int>();
    parenthesesStack.push(-1);
    var longest = 0

    for(i in s.indices){
        if(s[i] != '(' && parenthesesStack.size > 1 && s[parenthesesStack.peek()] == '('){


            parenthesesStack.pop();
            longest = max(longest, i - parenthesesStack.peek())
        }
        else{
            parenthesesStack.push(i)
        }
    }



    return longest;

}