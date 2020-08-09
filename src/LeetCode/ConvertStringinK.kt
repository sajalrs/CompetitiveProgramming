package LeetCode

fun main(){
    println(canConvertString("input","ouput",9))
    println(canConvertString("abc","bcd",9))
    println(canConvertString("aab","bbb",27))
    println(canConvertString("abc","abcd",27))
    println(canConvertString("iqssxdlb","dyuqrwyr",27))
    println(canConvertString("hxvcyvn","xbzgtou",28))
}


fun canConvertString(s:String, t:String, k:Int): Boolean {
    if(s.length != t.length){
        return false
    }

    var movesArray = IntArray(26)
    var cycles = k/26
    var remainder = k%26

    for(i in 0 until 26){
        movesArray[i]+=cycles
        if(i<=remainder){movesArray[i]++}
    }

    var i = 0
    while(i<s.length){
        if(s[i]==t[i]){
            i++
        } else{
            var diff = (t[i]-s[i]+26)%26
            movesArray[diff]--

            if(movesArray[diff]<0) return false
            else i++
        }


    }

    return true
}