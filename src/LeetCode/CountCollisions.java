package LeetCode;

public class CountCollisions {
    public int countCollisions(String directions) {

        char[] charArray = new char[directions.length()];
        for(int i=0; i<directions.length(); i++){
            charArray[i] = directions.charAt(i);
        }

        int collisions = 0;
        for(int i=1; i<charArray.length; i++){
            char direction = charArray[i];
            if(direction == 'L'){
                if(charArray[i-1] == 'S' || charArray[i-1] == 'R'){
                    charArray[i] = 'S';
                    collisions++;
                }
            }
        }

        for(int i=charArray.length-2; i>=0; i--){
            char direction = charArray[i];
            if(direction == 'R'){
                if(charArray[i+1] == 'S' || charArray[i+1] == 'L'){
                    charArray[i] = 'S';
                    collisions++;
                }
            }
        }
        return collisions;
    }
}
