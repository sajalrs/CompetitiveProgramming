package LeetCode;

public class DivideStrings {
    public String[] divideString(String s, int k, char fill) {
        int numGroups = (int) Math.ceil((double) s.length()/k);
        String[] arr = new String[numGroups];
        for(int i =0; i<numGroups-1; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0; j<k; j++){
                stringBuilder.append(s.charAt(i*k + j));
            }
            arr[i] = stringBuilder.toString();
        }
        int nonFill = s.length() % k;

        if(nonFill == 0){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0; j<k; j++){
                stringBuilder.append(s.charAt((numGroups-1)*k + j));
            }
            arr[numGroups-1] = stringBuilder.toString();

        }else {
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<nonFill; i++){
                stringBuilder.append(s.charAt((numGroups-1)*k + i));
            }
            for(int i=nonFill; i<k;i++){
                stringBuilder.append(fill);
            }
            arr[numGroups-1] = stringBuilder.toString();
        }
        return arr;
    }
}
