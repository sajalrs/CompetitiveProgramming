package LeetCode;

public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder withSpaces = new StringBuilder(s.length() + spaces.length);

        int curIndex = 0;
        int spaceHere = spaces[curIndex];
        for(int i=0; i<s.length(); i++){
            if(i == spaceHere){
                withSpaces.append(" ");
                if(curIndex < spaces.length - 1){
                    curIndex++;
                    spaceHere = spaces[curIndex];
                }
            }
            withSpaces.append(s.charAt(i));
        }

        return withSpaces.toString();
    }
}
