package Practice;

public class MinSwaps {
    public int minSwaps(int[] data) {
        int[] freq = new int[data.length+1];
        for (int i = 1; i <= data.length; i++) {
            freq[i] = freq[i-1] + data[i-1];
        }
        int count = freq[data.length];
        int total = count;
        for (int i = count; i <= data.length; i++) {
            int localCount = freq[i] - freq[i-count];
            total = Math.min(total, count - localCount);
        }
        return total;
    }

    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();
        System.out.println(minSwaps.minSwaps(new int[]{1, 0, 1, 0, 1}));
//        System.out.println(minSwaps.minSwaps(new int[]{0, 0, 0, 1, 0}));
//        System.out.println(minSwaps.minSwaps(new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1}));
//        System.out.println(minSwaps.minSwaps(new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1}));
        System.out.println(minSwaps.minSwaps(new int[]{1,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,1,0,0,0,1,0,0,1,1,1,0,0,1,0,0,0,1,1,1,1,1,1,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,0,1,0,1,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,1,1,0,1,0,1,0,0,1,0,1,1,0,0,1,0,0,1,0,1,1,0,0,1,0,0,0,0,0,1,1,1,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,1,1,1,0,0,0,1,1,1,1,1,0,1,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,1,0,1,0,0,1,0,1,0,1,0}));
    }
}
