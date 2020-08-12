package LeetCode

/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 */
fun main(){
    println(checkRecord("AA"))
}

fun checkRecord(s: String): Boolean {
    var absentDays = 0
    for(i in 0 until s.length){
        if(i>=2){
            if(s[i] == 'L' && s[i-1] == 'L' && s[i-2] =='L'){
                return false
            }
        }
        if(s[i] == 'A'){
            absentDays++
        }
        if(absentDays==2){
            return false
        }

    }

    return true
}