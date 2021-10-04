package LeetCode;

public class CheckIntegersInRangeCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean isCovered = false;
            for (int j = 0; j < ranges.length; j++) {
                if ((i >= ranges[j][0] && i <= ranges[j][1])) {
                    isCovered = true;
                }
            }
            if(!isCovered) return false;
        }
        return true;
    }
}
