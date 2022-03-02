package CrackingTheCodingInterview;

public class StringCompression {
    public String stringCompression(String word){
        if(word.length() == 0) return word;
        StringBuilder compressedString = new StringBuilder();
        int i=0;
        char prevChar = word.charAt(0);
        compressedString.append(prevChar);
        int noOfReps = 0;
        while(i<word.length()){
            char curChar = word.charAt(i);
            if(prevChar == curChar){
                noOfReps++;
            }else {
                compressedString.append(noOfReps);
                compressedString.append(curChar);
                noOfReps = 1;
            }
            prevChar = curChar;
            i++;
        }
        compressedString.append(noOfReps);
        String compressed = compressedString.toString();
        return compressed.length() < word.length() ? compressed : word;
    }


}
