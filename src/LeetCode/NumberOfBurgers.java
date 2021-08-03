package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfBurgers {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        int jumbo_total = Math.floorDiv((tomatoSlices - (2 * cheeseSlices)), 2);
        int small_total = cheeseSlices - jumbo_total;

        List<Integer> toReturn = new ArrayList<>();
        if (jumbo_total >= 0 && small_total >= 0 && (((4 * jumbo_total) + (2 * small_total)) == tomatoSlices) && (jumbo_total + small_total == cheeseSlices)) {
            toReturn.add(jumbo_total);
            toReturn.add(small_total);
        }

        return toReturn;
    }


}
