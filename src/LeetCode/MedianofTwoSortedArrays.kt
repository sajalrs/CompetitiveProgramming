package LeetCode

fun main(){
    val arr1 = arrayOf(1,3).toIntArray()
    val arr2 = arrayOf(2).toIntArray()
    print(findMedianSortedArrays(arr1,arr2))
}

fun findMedianSortedArrays(nums1: IntArray, nums2:IntArray):Double{
    var a = nums1
    var b = nums2
    var m = a.size
    var n = b.size

    if(m > n){
        var temp = a
        a = b
        b = temp

        var tmp = m
        m = n
        n = tmp
    }

    var iMin = 0
    var iMax = m
    var halfLen = (m+n+1)/2

    while(iMin <= iMax){
        var i = (iMin + iMax)/2
        var j = halfLen - i
            if(i < iMax && b[j-1] > a[i]){
                iMin = i + 1
            } else if(i > iMin && a[i-1]> b[j]) {
                iMax = i - 1
            }else {
                var maxLeft = 0
                if(i==0){maxLeft = b[j-1]}
                else if(j ==0){maxLeft = a[i-1]}
                else {maxLeft = Math.max(a[i-1],b[j-1])}

                if((m+n)%2 == 1) {return maxLeft.toDouble()}

                var minRight = 0
                if(i==m) {minRight = b[j]}
                else if(j==n){minRight = a[i]}
                else{minRight = Math.min(b[j], a[i])}

                return (maxLeft+minRight)/2.0
            }
    }
    return  0.0
}