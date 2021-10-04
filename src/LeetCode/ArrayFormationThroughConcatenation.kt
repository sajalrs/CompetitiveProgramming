package LeetCode

fun main(){
    var arr = intArrayOf(15,18)
    var pieces = arrayOf(intArrayOf(88),intArrayOf(15))

    print(canFormArray(arr, pieces))
}


fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {

    var pickedArray = BooleanArray(pieces.size).map { _ -> false }.toMutableList();
    var curIndex = 0;

    for (i in pieces.indices) {

        if (pickedArray[i]) continue;
        val prevIndex = curIndex
        for (j in pieces[i].indices) {
            if (arr[curIndex] == pieces[i][j]) {
                curIndex++
            } else {
                curIndex -= j
                break
            }
        }

        if (prevIndex != curIndex) {
            pickedArray[i] = true
        }

    }

    return curIndex == arr.size


}

