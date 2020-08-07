package LeetCode

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
fun main(){

 print(convert("PAYPALISHIRING", 3))

}

fun convert(s: String, numRows: Int): String {
    if(numRows==1){
        return s
    }


    var matrix = Array (numRows) {CharArray(s.length){ _ -> ' '} }

    var counter = 0
    var curIndex = 0
    var goingDown = true
    var j = 0
    var i = 0
    var return2 = ""

    while(curIndex < s.length){
        matrix[i][j] = s[curIndex]
        curIndex++
        if(goingDown){
            if(i == numRows - 1){
                goingDown = false
                i--
                j++
                counter++
                continue
            }
            i++
        }

        if(!goingDown){
            if(i==0){
                goingDown=true
                i++
                continue
            }
            i--
            j++
            counter++
        }
    }

    var returnString = ""
    for(k in 0 until numRows){
        for(l in 0 until j+1){
            val curChar = matrix[k][l]
            if(curChar!=' '){
                returnString+= curChar
            }
        }
    }

    return returnString
}