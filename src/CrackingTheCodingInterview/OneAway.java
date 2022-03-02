package CrackingTheCodingInterview;

public class OneAway {
    public boolean oneAway(String first, String second){
        int firstLength = first.length();
        int secondLength = second.length();
        if(Math.abs(firstLength-secondLength) > 1) return false;
        int curFirst = 0;
        int curSecond = 0;

        boolean replacedOneAlready = false;
        while (curFirst <firstLength && curSecond < secondLength ){
            if(first.charAt(curFirst) != second.charAt(curSecond)) {
                if (firstLength == secondLength) {
                    if(replacedOneAlready) {
                        return false;
                    }
                    replacedOneAlready = true;
                    curFirst++;
                    curSecond++;
                } else if (firstLength > secondLength) {
                    curFirst++;
                } else {
                    curSecond++;
                }
            }else {
                curFirst++;
                curSecond++;
            }
        }
        return Math.abs(curFirst - curSecond) <= 1;
    }
}
