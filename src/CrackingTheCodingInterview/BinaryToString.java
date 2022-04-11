package CrackingTheCodingInterview;

public class BinaryToString {
    public String binaryToString(double num){
        if(num >= 1 || num <= 0) return "ERROR";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0.");
        double frac = 0.5;
        while (num > 0){
            if(stringBuilder.length() > 32) return "ERROR";
            if(num>=frac){
                num-=frac;
                stringBuilder.append('1');
            }else {
                stringBuilder.append('0');
            }
            frac/=2;
        }
        return stringBuilder.toString();
    }
    public static void main(String args[]) {
        BinaryToString binaryToString = new BinaryToString();
        System.out.println(binaryToString.binaryToString(0.25));
        System.out.println(binaryToString.binaryToString(0.621));
        System.out.println(binaryToString.binaryToString(0.1));
    }

}
