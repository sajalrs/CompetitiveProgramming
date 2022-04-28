package Practice;

import java.lang.reflect.Array;
import java.util.*;

public class FindSongs {
    public static List<Integer> findSongs(int rideDuration, List<Integer> songDurations) {
        // Write your code here
        if(rideDuration < 30) return Arrays.asList(new Integer[]{-1,-1});
        if(songDurations.size() < 2) return Arrays.asList(new Integer[]{-1,-1});
        Map<Integer, Integer> remainingLengthSongs = new HashMap<>();
        //TODO: Implement custom class
        List<Integer[]> possibleSongPairs = new ArrayList<>();

        for(int secondSong=0; secondSong<songDurations.size(); secondSong++){
            if(secondSong == 3){
                System.out.println("Yo");
            }
            int songDuration = songDurations.get(secondSong);
            int remainingLength = (rideDuration-30)-songDuration;
            if(remainingLengthSongs.containsKey(remainingLength)){
                int firstSong = remainingLengthSongs.get(remainingLength);
                if(secondSong== firstSong) continue;
                possibleSongPairs.add(new Integer[]{firstSong, secondSong});
            }
            remainingLengthSongs.put(remainingLength, secondSong);
        }
        Collections.sort(possibleSongPairs, (a,b) -> Math.max(songDurations.get(b[0]), songDurations.get(b[1])) - Math.max(songDurations.get(a[0]), songDurations.get(a[1])));
        return Arrays.asList(possibleSongPairs.get(0));

    }

    public static void main(String[] args){
        System.out.println(findSongs(90, Arrays.asList(new Integer[]{1,10,25,35,60})));
    }
}
