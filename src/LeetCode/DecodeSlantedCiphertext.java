package LeetCode;

import java.util.Arrays;

public class DecodeSlantedCiphertext {
    public String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) return encodedText;
        if(encodedText.length() == 0) return  "";


        int cols = encodedText.length()/rows;
        char[][] cipherMatrix = new char[rows][cols];
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                cipherMatrix[i][j] = encodedText.charAt(count++);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int k =0; k<cols; k++){
            int i = 0;
            int j = k;
            while (i<rows && j<cols){
                stringBuilder.append(cipherMatrix[i][j]);
                i++;
                j++;
            }
        }
        int l = stringBuilder.length() - 1;
        while (stringBuilder.charAt(l) == ' '){
            stringBuilder.deleteCharAt(l);
            l--;
        }

        return stringBuilder.toString();
    }
}
