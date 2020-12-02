package LeetCode;

public class MaximumRepeatingSubstring {

    public static int maxRepeating(String sequence, String word) {

        int wordLength = word.length();
        if(wordLength>sequence.length()){
            return 0;
        }
        int k = 0;
        int specialK = 0;
        int i = 0;
        while(i< sequence.length()){
            int j = 0;
            boolean match = true;
            while(j < wordLength){
                if(i+j<sequence.length()){
                    if( sequence.charAt(i+j) != word.charAt(j)){
                        match = false;
                        break;
                    }
                    j++;
                } else {
                    match = false;
                    break;
                }

            }
            if(match){
               k++;
               i+=wordLength;
            } else{
                specialK = Math.max(k, specialK);
                k=0;
                i++;
            }

        }
        specialK = Math.max(k, specialK);
        return specialK;
    }

    public static void main(String[] args){

        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating("ababc", "ac"));
        System.out.println(maxRepeating("a", "a"));
        System.out.println(maxRepeating("a", "aa"));
    }

}
