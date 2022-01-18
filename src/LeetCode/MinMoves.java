package LeetCode;

public class MinMoves {
    public int minMoves(int target, int maxDoubles) {
        return recursion(target, maxDoubles);
    }

    private int recursion(int curNum, int maxDoubles){
        if(curNum == 1){
            return 0;
        } else if(maxDoubles <= 0) {
            return curNum-1;
        } else {
            if(curNum % 2 == 0){
                return 1 + recursion(curNum/2, maxDoubles-1);
            }else {
                return 1+recursion(curNum-1, maxDoubles);
            }
        }
    }
}
