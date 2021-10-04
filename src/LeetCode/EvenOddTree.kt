package LeetCode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main(){

}

fun isEvenOffTree(root: TreeNode?): Boolean{
    fun getHeight(root: TreeNode): Int{
        if(root == null)
            return 0
        else {
            var lheight = root.left?.let { getHeight(it) }
            var rheight = root.right?.let { getHeight(it) }

            if(lheight!! > rheight!!)
                return(lheight + 1)
            else
                return (rheight+1)
        }
    }

    fun getGivenLevel(level: Int): List<Int>{
        var levelValues = mutableListOf<Int>()

        fun populateLevelValues(root: TreeNode?, level: Int){
            if(root == null){
                return
            }
            if(level == 1){
                levelValues.add(root.`val`)
            }
            else if(level>1){
                populateLevelValues(root.left, level-1)
                populateLevelValues(root.right, level-1)
            }
        }

        populateLevelValues(root,level)
        return levelValues
    }

    fun isOddEvenIncreasing(levelValues: List<Int>, level: Int): Boolean{
        var prevValue = levelValues[0]

        fun isEvenOdd(num: Int): Boolean {
            if(level % 2 == 0){
                return num % 2 == 0
            } else {
                return num % 2 != 0
            }
        }

        if(!isEvenOdd(prevValue)){
            return false
        }


        for(i in 1 until levelValues.size){
            if(!isEvenOdd(levelValues[i])){
                return false
            }

            if((levelValues[i] < prevValue)){
                return false
            }

            prevValue = levelValues[i]
        }

        return true
    }

    fun checkEvenOddTree(): Boolean{
        val height = getHeight(root!!)
        for(i in 1 until height+1){
            if(!(isOddEvenIncreasing(getGivenLevel(i),i))) return false
        }
        return true
    }

    return checkEvenOddTree()

}