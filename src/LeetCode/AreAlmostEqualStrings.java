package LeetCode;

public class AreAlmostEqualStrings {

    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() == 1) return false;

        int outOfPlace = -1;
        int maxSwaps = 0;
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(outOfPlace == -1){
                    outOfPlace = i;
                } else {
                    if(s1.charAt(outOfPlace) != s2.charAt(i)){
                        return false;
                    } else if(maxSwaps >=1){
                        return false;
                    }else{
                        maxSwaps ++;
                        outOfPlace = -1;
                    }
                }
            }

        }
        return outOfPlace == -1;
    }


    public static void main(String[] args){
        System.out.println(areAlmostEqual("bank", "kanb"));

        System.out.println(areAlmostEqual("attack", "defend"));

        System.out.println(areAlmostEqual("kelb", "kelb"));

        System.out.println(areAlmostEqual("abcd", "dcba"));
    }
}
