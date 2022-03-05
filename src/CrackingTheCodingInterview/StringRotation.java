package CrackingTheCodingInterview;

public class StringRotation {
    public boolean stringRotation(String s1, String s2){
        int len = s1.length();
        if(len > 0 && len != 0){
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    private boolean isSubstring(String s1, String s2){
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        int i=0;
        while (i<lenS1){
            int j=0;
            while (j<lenS2 && i+j+1<lenS1){
                if(s1.charAt(i+j+1) != s2.charAt(j)){
                    break;
                }
                j++;
            }
            if(j==lenS2){
                return true;
            }
            i+=j+1;
        }
        return false;
    }
}
