package LeetCode

fun main(){
    println(isMatch("aa","a"))
    println(isMatch("aa","a*"))
    println(isMatch("ab",".*"))
    println(isMatch("aab","c*a*b"))
    println(isMatch("mississippi","mis*is*p"))

}

fun isMatch(s:String, p:String): Boolean{

    fun isMatch(s:String, p:String, pred: Char, dp: HashMap<String,Boolean>): Boolean? {
        var key = "$s=$p"
        if(dp.containsKey(key)) return dp[key]

        var ans = false

        if(s.isEmpty()){
            if(p.isEmpty()){
                ans = true
            }
            if(pred != 0.toChar()){
                ans = isMatch(s,p.substring(1),0.toChar(), dp)!!
            }else if(p.length > 1 && p[1] == '*') {
                ans = isMatch(s,p.substring(2),0.toChar(), dp)!!
            }
        }
        else if(p.isEmpty()){
            ans = false
        }
        else {
            if(pred != 0.toChar()){
                if(s[0] == pred || pred == '.'){
                    ans = isMatch(s.substring(1),p, pred,dp)!! ||
                            isMatch(s,p.substring(1),0.toChar(),dp)!!
                } else {
                    ans = isMatch(s,p.substring(1),0.toChar(), dp)!!
                }
            } else if(p.length > 1 && p[1] == '*'){
                ans = isMatch(s, p.substring(1), p[0], dp)!!
            } else if(s[0] == p[0] || p[0] == '.'){
                ans = isMatch(s.substring(1), p.substring(1), 0.toChar(), dp)!!
            }


        }
        dp[key] = ans
        return ans
    }

    return isMatch(s, p, 0.toChar(),HashMap<String, Boolean>())!!
}

