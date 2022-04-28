package CrackingTheCodingInterview;

public class MagicIndex {
    public int magicIndex(int[] arr) {
        return magicIndexBinarySearch(0, arr.length - 1, arr);
    }

    private int magicIndexBinarySearch(int l, int r, int[] arr) {
        if (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == m) return m;
            int leftIndex = Math.min(m - 1, arr[m]);
            int left = magicIndexBinarySearch(0, leftIndex, arr);
            if (left != -1) return left;
            int rightIndex = Math.max(m + 1, arr[m]);
            int right = magicIndexBinarySearch(rightIndex, r, arr);
            if (right != -1) return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        MagicIndex magicIndex = new MagicIndex();
        System.out.println(magicIndex.magicIndex(new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}));
        System.out.println(magicIndex.magicIndex(new int[]{-10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13}));
    }
}
