package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DigArtifacts {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] site: dig){
            int row = site[0];
            int col = site[1];
            if(!map.containsKey(row)){
                map.put(row, new HashSet<>());
            }
            map.get(row).add(col);
        }
        int count =0;
        for(int[] artifact: artifacts){
            int r1 = artifact[0];
            int c1= artifact[1];
            int r2 = artifact[2];
            int c2 = artifact[3];

            boolean excavatedArtifact = true;
            for(int i=r1; i<=r2 && excavatedArtifact; i++){
                for(int j=c1; j<=c2 && excavatedArtifact; j++){
                    if(!(map.containsKey(i) && map.get(i).contains(j))){
                           excavatedArtifact = false;
                    }
                }
            }
            if(excavatedArtifact) count++;
        }
        return count;
    }
}
