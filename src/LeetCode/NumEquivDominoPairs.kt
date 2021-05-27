package LeetCode

fun main() {
    println(numEquivDominoPairs(arrayOf(intArrayOf(2,1),intArrayOf(1,2),intArrayOf(3,4),intArrayOf(5,6))))
    println(numEquivDominoPairs(arrayOf(intArrayOf(1,2),intArrayOf(1,2),intArrayOf(1,1),intArrayOf(1,2),intArrayOf(2,2))))
}

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
//    var isCounted = BooleanArray(dominoes.size) { _ -> false }
    var curDomino = 0
    var numEquiv = 0
    while (curDomino != dominoes.size) {
//        isCounted[curDomino] = true
        for (i in dominoes.indices) {
//            if (isCounted[i]) {
//                continue
//            }

            if(curDomino == i){
                continue
            }
            val pair = dominoes[curDomino]
            val equals = (dominoes[i][0] == pair[0] && dominoes[i][1] == pair[1]) ||
                    (dominoes[i][0] == pair[1] && dominoes[i][1] == pair[0])
            if (equals) {
                numEquiv++
//                isCounted[i] = true
            }
        }
        curDomino++
//        while (curDomino < dominoes.size && isCounted[curDomino]) {
//            curDomino++
//        }
    }
    return numEquiv/2
}